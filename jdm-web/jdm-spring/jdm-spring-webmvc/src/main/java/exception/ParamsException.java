/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author passpos <paiap@outlook.com>
 */
public class ParamsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer code = 300;
    private String msg = "参数异常";

    public ParamsException() {
        super("参数异常");
    }

    public ParamsException(String message) {
        super("参数异常");
    }

    public ParamsException(Integer code) {
        super("参数异常");
        this.code = code;
    }

    public ParamsException(Integer code, String message) {
        super("参数异常");
        this.code = code;
        this.msg = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
