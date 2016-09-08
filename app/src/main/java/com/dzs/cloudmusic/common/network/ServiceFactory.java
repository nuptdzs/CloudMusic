package com.dzs.cloudmusic.common.network;

import android.annotation.TargetApi;
import android.os.Build;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dzs on 2016/8/22.
 */
public class ServiceFactory {
    /**
     * 需要实现retrofit的接口  必须含有BASE_URL字段
     * @param serviceClass
     * @param <S>
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static <S> S createService(Class<S> serviceClass){
        String baseUrl ="";
        try {
            Field field = serviceClass.getField("BASE_URL");
            baseUrl = (String) field.get(serviceClass);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return build(baseUrl).build().create(serviceClass);
    }

    private static OkHttpClient client;

    private static OkHttpClient getClient() {
        if (client == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder =  new OkHttpClient.Builder();
            builder.readTimeout(8, TimeUnit.SECONDS);
            builder.writeTimeout(8, TimeUnit.SECONDS);
            builder.connectTimeout(5, TimeUnit.SECONDS);
            builder.addInterceptor(loggingInterceptor);
            client = builder.build();
        }
        return client;
    }
    private static Retrofit.Builder build(String baseurl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.baseUrl(baseurl);
        //builder.client(getClient());
        return builder;
    }
}
