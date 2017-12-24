package org.sxd.invmgmt.common;

/**
 * Created by eddie on 2017/12/19.
 * 接口返回的结果实体类
 */
public class Result<T> {
    /**
     * 操作是否成功
     */
    private boolean success;

    /**
     * 操作提示信息
     */
    private String msg;

    /**
     * 操作返回数据的对象
     */
    private T obj;

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public Result(boolean success, String msg, T obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
