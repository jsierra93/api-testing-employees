package co.com.jsierra.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertirObjeto {

    private static Gson gson;

    public static <T> T desdeJson(String json, Class<T> classOfT) {
        gson = new GsonBuilder().create();
        return gson.fromJson(json, classOfT);
    }
}
