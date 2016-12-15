package com.hht.view;

import com.hht.utils.JsonUtil;

/**
 * 响应结果视图
 *
 * @author panghui
 * @version 1.0
 * @since 2016-11-30
 */
public class ResultView {

    // 响应状态
    private int result;

    // 响应信息
    private String message;

    // 响应数据
    private Object obj;

    public ResultView(int result,Object obj,String message){
        this.result = result;
        this.message = message;
        this.obj = obj;
    }

    public ResultView(int result,Object obj){
        this.result = result;
        this.obj = obj;
    }

    public ResultView(int result,String message){
        this.result = result;
        this.message = message;
    }

    public String toJsonString(){
        return JsonUtil.objectToJson(this);
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
