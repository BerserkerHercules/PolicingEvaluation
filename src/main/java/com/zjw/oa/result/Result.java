package com.zjw.oa.result;

/**
 * 统一 API响应结果封装,控制Result权限，
 * 构建结果Result对象统一使用com.javalsj.blog.vo.ResultFactory工厂类来创建
 *
 * @author ZhengJiawei
 * @create 2019-03-20 16:51
 */
public class Result {

    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应提示信息
     */
    private String message;
    /**
     * 响应结果对象
     */
    private Object data;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
