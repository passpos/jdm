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
public class BussinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer code = 400;
    private String msg = "业务异常";

    public BussinessException() {
        super("业务异常");
    }

    public BussinessException(String message) {
        super("业务异常");
        this.msg = message;
    }

    public BussinessException(Integer code) {
        super("业务异常");
        this.code = code;
    }

    public BussinessException(Integer code, String message) {
        super("业务异常");
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
