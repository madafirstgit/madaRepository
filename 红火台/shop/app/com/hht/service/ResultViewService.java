package com.hht.service;

import com.hht.constants.Constant;
import com.hht.view.ResultView;

/**
 * Created by WuJiaWen on 2016/12/8.
 */
public class ResultViewService {

    /**
     * 返回成功
     * @param obj 返回对象
     * */
    protected ResultView ok(Object obj){
        ResultView result = new ResultView(Constant.RESULT_SUCCESS,obj);
        return result;
    }

    /**
     * 返回成功
     * @param obj 返回对象
     * @param msg 返回消息
     * */
    protected ResultView ok(Object obj,String msg){
        ResultView result = new ResultView(Constant.RESULT_SUCCESS,obj,msg);
        return result;
    }

    /**
     * 返回失败
     * @param obj 返回对象
     * @param msg 返回消息
     * */
    protected ResultView error(Object obj,String msg){
        ResultView result = new ResultView(Constant.RESULT_FAIL,obj,msg);
        return result;
    }

    /**
     * 返回失败
     * @param msg 返回消息
     * */
    protected ResultView error(String msg){
        ResultView result = new ResultView(Constant.RESULT_FAIL,msg);
        return result;
    }
}
