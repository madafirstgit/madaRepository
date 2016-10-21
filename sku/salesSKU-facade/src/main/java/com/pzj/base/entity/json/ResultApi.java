package com.pzj.base.entity.json;

/**
 * @author liyh <levart@163.com>
 * @version 20160418
 */
public class ResultApi implements java.io.Serializable{

    private Boolean status;         // 请求状态 true|false
    private String  error;          // 当为false时,显示错误信息
    private Object  response;       // 成功时返回对象

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResponse() {
        return response;
    }
    public void setResponse(Object response) {
        this.response = response;
    }

    /**
     * 成功返回
     * @param obj
     * @return
     */
    public static ResultApi success(Object obj){
        ResultApi r = new ResultApi();
        r.setStatus(true);
        r.setResponse(obj);
        return r;
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static ResultApi failed(String message){
        ResultApi r = new ResultApi();
        r.setStatus(false);
        r.setError(message);
        return r;
    }
}
