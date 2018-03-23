package cn.devcenter.framework.safencryption.core.user.bean;

import com.google.gson.Gson;

public class SafencryptResponse {

    private Integer type;
    private String data;

    public SafencryptResponse(Integer type, String data) {
        this.type = type;
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static SafencryptResponse newInstance(Integer type, String data) {
        return new SafencryptResponse(type, data);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
