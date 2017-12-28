package org.sxd.invmgmt.common;

/**
 * Created by eddie on 2017/12/26.
 */
public enum MsgEnum {
    NULL_PARAMETER ("参数不能为空"),
    OPRATION_FAILED("操作失败"),
    OPRATION_SUCCEED("操作成功"),
    NULL_RESULT("查询结果为空");

    private String msg;

    private MsgEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}