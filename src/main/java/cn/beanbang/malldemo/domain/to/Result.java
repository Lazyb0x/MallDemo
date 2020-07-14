package cn.beanbang.malldemo.domain.to;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    public Result() {
    }

    public Result(ResultCode resultCode, Object data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object object) {
        return new Result(ResultCode.SUCCESS, object);
    }

    public static Result faliure() {
        Result result = new Result();
        result.setResultCode(ResultCode.FAILURE);
        return result;
    }

    public static Result isSuccess(boolean success) {
        if (success) {
            return success();
        } else {
            return faliure();
        }
    }
}

enum ResultCode {
    SUCCESS(1, "成功"),
    FAILURE(500, "失败");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}