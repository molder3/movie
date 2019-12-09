package com.bw.movie;

import android.app.Application;



import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import rx.plugins.RxJavaPlugins;


/**
 * date:2019/11/13
 * author:金豪(Lenovo)
 * function:
 */
public class MyApplication extends Application {
    public static IWXAPI api;
    @Override
    public void onCreate() {
        super.onCreate();

        //磁盘缓存的配置
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPath(getCacheDir())
                .setMaxCacheSize(8*1024*1024)
                .build();
        //把磁盘缓存的设置，设置到三级缓存中
        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();

        Fresco.initialize(this,pipelineConfig);
        regToWx();
    }
    private void regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this,Constants.WX_APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(Constants.WX_APP_ID);

    }

    public static IWXAPI getWXApi(){
        return api;
    }
}
