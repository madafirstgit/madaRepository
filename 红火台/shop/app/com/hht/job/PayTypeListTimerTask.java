package com.hht.job;

import akka.actor.ActorSystem;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.hht.service.PayTypeService;
import com.hht.utils.JsonUtil;
import play.Logger;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * @author panghui
 * @version 1.0
 * @since 2016-12-09
 */
@Singleton
public class PayTypeListTimerTask {

    @Inject
    private PayTypeService payTypeService;

    @Inject
    public PayTypeListTimerTask(ActorSystem system) {

        Logger.info("初始化定时任务...");

        system.scheduler().schedule(Duration.create(50, TimeUnit.MILLISECONDS),Duration.create(10, TimeUnit.SECONDS),
                new Runnable() {
                    @Override
                    public void run() {
                        Logger.info("返回结果:"+ JsonUtil.objectToJson(payTypeService.getPayTypeList("{}")));
                    }
                }, system.dispatcher());

    }
}
