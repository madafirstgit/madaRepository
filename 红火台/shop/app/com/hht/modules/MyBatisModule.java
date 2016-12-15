package com.hht.modules;

import com.google.inject.Inject;
import com.google.inject.name.Names;
import com.hht.interceptor.GenCreateInterceptor;
import com.hht.interceptor.PagePlugin;
import com.hht.job.PayTypeListTimerTask;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import play.db.Database;

import javax.inject.Provider;
import javax.inject.Singleton;
import javax.sql.DataSource;

public class MyBatisModule extends org.mybatis.guice.MyBatisModule {

    @Override
    protected void initialize() {
        environmentId("development");
        bindConstant().annotatedWith(
                Names.named("mybatis.configuration.failFast")).
                to(true);
        bindDataSourceProviderType(PlayDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
        // 注入Mapper包中的所有Mapper类
        addMapperClasses("com.hht.mapper");

        // 添加MyBatis分页拦截器
        addInterceptorClass(PagePlugin.class);

        // 添加注解生成拦截器
        addInterceptorClass(GenCreateInterceptor.class);

    }

    // private static final Injector injector =

    /* Provides a {@link DataSource} from the {@link Database} which can be injected from Play. */
    @Singleton
    public static class PlayDataSourceProvider implements Provider<DataSource> {
        final Database db;

        @Inject
        public PlayDataSourceProvider(final Database db) {
            this.db = db;
        }


        @Override
        public DataSource get() {
            return db.getDataSource();
        }
    }

}