package com.pzj.base.common.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Statement;

/**
 * 
 * 
 * 项目名称：service.product.redis 类名称：JdbcUtils 类描述： 创建人：石月 创建时间：2014-6-14 下午2:26:04
 * 修改人：wushu 修改时间：2014-6-14 下午2:26:04 修改备注：
 * 
 * @version
 * 
 */
public final class JdbcUtils {

	private static DruidDataSource dataSource = null;

	public static long getRecordTotal(String sql) {
		long count = 0;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		} finally {
			close(rs, ps, con);
		}
		return count;
	}

	private JdbcUtils() {
		// 因为无须被构造，设为私有
	}

	static {// 设为static，使它只注册一次
		try {
			Properties prop = new Properties();
			InputStream is = ClassLoader
					.getSystemResourceAsStream("application.properties");
			prop.load(is);
			dataSource = new DruidDataSource();
			String driver = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String username = prop.getProperty("jdbc.username");
			String password = prop.getProperty("jdbc.password");
			int minIdle = Integer.parseInt(prop
					.getProperty("jdbc.pool.minIdle"));
			int maxActive = Integer.parseInt(prop
					.getProperty("jdbc.pool.maxActive"));

			dataSource.setDriverClassName(driver);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setUrl(url);
			// <!-- 配置初始化大小、最小、最大 -->
			dataSource.setMinIdle(minIdle);
			dataSource.setInitialSize(minIdle);
			dataSource.setMaxActive(maxActive);
			// <!-- 配置获取连接等待超时的时间 -->
			dataSource.setMaxWait(60000l);
			// <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
			dataSource.setTimeBetweenEvictionRunsMillis(60000l);
			// <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
			dataSource.setMinEvictableIdleTimeMillis(300000l);
			dataSource.setValidationQuery("SELECT 'x'");
			dataSource.setTestWhileIdle(true);
			dataSource.setTestOnBorrow(false);
			dataSource.setTestOnReturn(false);
			// <!-- 配置监控统计拦截的filters -->
			dataSource.setFilters("stat");
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();// 用连接池建立连接
	}

	public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// finally保证无论抛出什么异常，finally里面包含的代码都会被执行
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static List<Map<String, Object>> query(String sql)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			return wrapper(ps.executeQuery());
		} finally {
			close(null, ps, con);
		}
	}

	public static List<Map<String, Object>> query(String sql, String... params)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			return wrapper(ps.executeQuery());
		} finally {
			close(null, ps, con);
		}
	}

	public static Long count(String sql, String... params) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getLong(1);
			}
			return 0L;
		} finally {
			close(rs, ps, con);
		}
	}

	public static int update(String sql, String... params) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int id = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			int num = ps.executeUpdate();

			if (num > 0) {
				ResultSet res = ps.getGeneratedKeys();
				if (res.next())
					id = res.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, ps, con);
		}
		return id;
	}

	public static int update(String sql, int param, String... params)
			throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, param);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 2, params[i]);
			}
			int num = ps.executeUpdate();

			if (num > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, con);
		}
		return id;
	}

	public static Long getTotalPage(long totalCount, long pageSize) {
		if (totalCount % pageSize == 0) {
			return totalCount / pageSize;
		} else {
			return totalCount / pageSize + 1;
		}
	}

	private static List<Map<String, Object>> wrapper(ResultSet rs)
			throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {// 循环表
				Map<String, Object> map = new HashMap<String, Object>();
				// 每行记录放到一个对象中
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					map.put(rsmd.getColumnLabel(i), rs.getString(i));
				}
				list.add(map);
			}
			return list;
		} finally {
			close(rs, null, null);
		}
	}
}