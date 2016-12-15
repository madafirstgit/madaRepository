package com.hht.modules;

import com.google.inject.AbstractModule;
import com.hht.job.PayTypeListTimerTask;
import play.Logger;

/**
 * Created by qi_grui on 2016/12/2.
 */
public class SchedulerModule extends AbstractModule{

    @Override
    protected void configure() {

        Logger.info("启动定时任务加载执行器...");

        bind(PayTypeListTimerTask.class).asEagerSingleton();

    }
}
