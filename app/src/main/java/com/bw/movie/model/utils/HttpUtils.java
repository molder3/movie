package com.bw.movie.model.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bw.movie.api.APi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class HttpUtils {
    private Retrofit retrofit;
    private static HttpUtils utls;
    private HttpUtils(){
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        retrofit=new Retrofit.Builder()
                .client(client)
                .baseUrl(APi.BUSEL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public static synchronized HttpUtils getUtls(){
        if (utls==null){
            utls=new HttpUtils();
        }
        return utls;
    }
    //网络状态
    public boolean iswork(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;
    }
    public <T> T getClass(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
