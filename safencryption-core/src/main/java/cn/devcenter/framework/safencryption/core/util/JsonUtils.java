package cn.devcenter.framework.safencryption.core.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    public static Gson getGsonInstance() {
        return gson;
    }

}
