package com.hht.interceptor;


import com.hht.utils.ReflectUtil;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import javax.xml.bind.PropertyException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * SQL查询分页拦截器
 *
 * @author panghui
 * @version 1.0
 * @since 2016/7/28
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagePlugin implements Interceptor {

    // 数据库方言
    private static String dialect = "mysql";
    // 查询方法ID
    private static String pageSqlId = ".*ListPage.*";

    public Object intercept(Invocation invocation) throws Throwable {

        if (invocation.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation
                    .getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectUtil
                    .getFieldValue(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil
                    .getFieldValue(delegate, "mappedStatement");

            if (mappedStatement.getId().matches(pageSqlId)) {
                BoundSql boundSql = delegate.getBoundSql();
                Object parameterObject = boundSql.getParameterObject();
                if (parameterObject == null) {
                    throw new NullPointerException("parameterObject");
                } else {
                    Connection connection = (Connection) invocation.getArgs()[0];
                    String sql = boundSql.getSql();
                    String countSql = "select count(0) from (" + sql
                            + ") as s1 ";
                    PreparedStatement countStmt = connection
                            .prepareStatement(countSql);
                    BoundSql countBS = new BoundSql(
                            mappedStatement.getConfiguration(), countSql,
                            boundSql.getParameterMappings(), parameterObject);
                    setParameters(countStmt, mappedStatement, countBS,
                            parameterObject);
                    ResultSet rs = countStmt.executeQuery();
                    int count = 0;
                    if (rs.next()) {
                        count = rs.getInt(1);
                    }
                    rs.close();
                    countStmt.close();

                    Page page = null;
                    if (parameterObject instanceof Page) {
                        page = (Page) parameterObject;
                        page.setTotalRecord(count);
                    } else if (parameterObject instanceof Map) {
                        Map<String, Object> map = (Map<String, Object>) parameterObject;
                        page = (Page) map.get("page");
                        if (page == null)
                            page = new Page();
                        page.setTotalRecord(count);
                    } else {
                        Field pageField = ReflectUtil.getField(
                                parameterObject, "page");
                        if (pageField != null) {
                            page = (Page) ReflectUtil.getFieldValue(
                                    parameterObject, "page");
                            if (page == null)
                                page = new Page();
                            page.setTotalRecord(count);
                            ReflectUtil.setFieldValue(parameterObject,
                                    "page", page);
                        } else {
                            throw new NoSuchFieldException(parameterObject
                                    .getClass().getName());
                        }
                    }
                    String pageSql = generatePageSql(sql, page);
                    ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
                }
            }
        }
        return invocation.proceed();
    }

    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    /**
     * 根据接口setProperties 方法，获取到配置文件中plugin属性Property的值
     * 设置到当前拦截器中
     *
     * @param properties
     */
    public void setProperties(Properties properties) {
        dialect = properties.getProperty("dialect");
        if (dialect == null || dialect.equals("")) {
            try {
                throw new PropertyException("dialect property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
        pageSqlId = properties.getProperty("pageSqlId");
        if (pageSqlId == null || pageSqlId.equals("")) {
            try {
                throw new PropertyException("pageSqlId property is not found!");
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过parameterHandler给PreparedStatement对象设置参数
     *
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps,
                               MappedStatement mappedStatement, BoundSql boundSql,
                               Object parameterObject) throws SQLException {
        ErrorContext.instance().activity("setting parameters")
                .object(mappedStatement.getParameterMap().getId());
        List<ParameterMapping> parameterMappings = boundSql
                .getParameterMappings();
        if (parameterMappings != null) {
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration
                    .getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null
                    : configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry
                            .hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
                            && boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null) {
                            value = configuration.newMetaObject(value)
                                    .getValue(
                                            propertyName.substring(prop
                                                    .getName().length()));
                        }
                    } else {
                        value = metaObject == null ? null : metaObject
                                .getValue(propertyName);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null) {
                        throw new ExecutorException(
                                "There was no TypeHandler found for parameter "
                                        + propertyName + " of statement "
                                        + mappedStatement.getId());
                    }
                    typeHandler.setParameter(ps, i + 1, value,
                            parameterMapping.getJdbcType());
                }
            }
        }
    }


    /**
     * 根据数据库类型，拼装分页SQL
     *
     * @param sql
     * @param page
     * @return
     */
    protected String generatePageSql(String sql,Page page) {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        if ("mysql".equalsIgnoreCase(dialect)) {
            return getMysqlPageSql(page, sqlBuffer);
        } else if ("oracle".equalsIgnoreCase(dialect)) {
            return getOraclePageSql(page, sqlBuffer);
        }
        return sqlBuffer.toString();
    }

    /**
     * 获取MYSQL的分页SQL
     *
     * @param page
     * @param sqlBuffer
     * @return
     */
    protected String getMysqlPageSql(Page page, StringBuffer sqlBuffer) {
        // 计算第一条记录的位置，Mysql中记录的位置是从0开始的。
        int offset = (page.getPageNum() - 1) * page.getPageRecordCount();
        sqlBuffer.append(" limit ").append(offset).append(",")
                .append(page.getPageRecordCount());
        return sqlBuffer.toString();
    }

    /**
     * 获取ORACLE 的分页SQL
     *
     * @param page
     * @param sqlBuffer
     * @return
     */
    protected String getOraclePageSql(Page page, StringBuffer sqlBuffer) {
        // 计算第一条记录的位置，Oracle分页是通过rownum进行的，而rownum是从1开始的
        int offset = (page.getPageNum() - 1) * page.getPageRecordCount() + 1;
        sqlBuffer.insert(0, "select u.*, rownum r from (")
                .append(") u where rownum < ")
                .append(offset + page.getPageRecordCount());
        sqlBuffer.insert(0, "select * from (").append(") where r >= ")
                .append(offset);
        // 上面的Sql语句拼接之后大概是这个样子：
        // select * from (select u.*, rownum r from (select * from t_user) u
        // where rownum < 31) where r >= 16
        return sqlBuffer.toString();
    }

}
