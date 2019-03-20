package com.zjw.oa.result;

/**
 * 响应结果生成工厂类
 *
 * @author ZhengJiawei
 * @create 2019-03-20 16:54
 */
public class ResultFactory {

    public static Result buildSuccessResult(Object data) {
        return buidResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buidResult(ResultCode.FAIL, message, null);
    }

    private static Result buidResult(ResultCode resultCode, String message, Object data) {
        return buidResult(resultCode.code, message, data);
    }

    private static Result buidResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }

}
