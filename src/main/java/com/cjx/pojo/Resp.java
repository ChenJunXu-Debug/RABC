/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Resp
 * Author:   ASUS
 * Date:     2020/6/25 9:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.pojo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author cjx
 * @create 2020/6/25
 * @since 1.0.0
 */
public class Resp {
    private int status;
    private String msg;
    private Object data;

    private Resp(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Resp() {
    }

    public static Resp ok(String msg, Object data) {
        return new Resp(200, msg, data);
    }

    public static Resp fail(String msg, Object data) {
        return new Resp(0, msg, data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
