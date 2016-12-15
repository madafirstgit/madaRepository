

package com.hht.interceptor;

import com.hht.utils.BeanIdCreater;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Properties;


@Intercepts({ @Signature(type = Executor.class, method = "update", args = {
		MappedStatement.class, Object.class }) })
public class GenCreateInterceptor implements Interceptor {

	private Logger log = LoggerFactory.getLogger(GenCreateInterceptor.class);

	private Properties properties;


	public Properties getProperties() {
		return properties;
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = null;
		if (invocation.getArgs().length > 1) {
			parameter = invocation.getArgs()[1];
		}
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		boolean isInsert = isInsert(boundSql);
		if (!isInsert) {
			return invocation.proceed();
		} else {
			return handleCreate(invocation, boundSql, mappedStatement);
		}
	}

	public Object handleCreate(Invocation invocation, BoundSql boundSql,
			MappedStatement mappedStatement) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Configuration configuration = mappedStatement.getConfiguration();
		Object parameterObject = boundSql.getParameterObject();
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings.size() > 0 && parameterObject != null) {
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {

			} else {
				MetaObject metaObject = configuration.newMetaObject(parameterObject);
				for (ParameterMapping parameterMapping : parameterMappings) {
					String propertyName = parameterMapping.getProperty();
					if (metaObject.hasGetter(propertyName)) {
						if (!configuration.isUseGeneratedKeys()
								&& "ID".equals(propertyName.toUpperCase())) {
							metaObject
									.setValue(
											propertyName,
											genID(parameterObject.getClass().getName()));
						}
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						if (!configuration.isUseGeneratedKeys()
								&& "ID".equals(propertyName.split("\\.")[1]
										.toUpperCase())) {
							boundSql.setAdditionalParameter(
									propertyName,
									genID(parameterObject.getClass().getName()));
						}
					}
				}
			}
		}
		return exeInsert(invocation, mappedStatement);
	}

	private String genID(String objectName) {
		return BeanIdCreater.getInstance().getBeanIdCreater(objectName).nextId();
	}

	public Object exeInsert(Invocation invocation,
			MappedStatement insert_statement) throws IllegalAccessException,
			InvocationTargetException {
		Object[] args = invocation.getArgs();
		return invocation.getMethod().invoke(invocation.getTarget(),
				new Object[] { insert_statement, args[1] });
	}

	public boolean isInsert(BoundSql boundSql) {
		return boundSql.getSql().toUpperCase().indexOf(" INTO ") != -1;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties0) {
		this.properties = properties0;
	}
}