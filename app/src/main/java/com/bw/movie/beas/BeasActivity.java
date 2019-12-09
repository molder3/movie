package com.bw.movie.beas;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bw.movie.R;
import com.bw.movie.contract.IBeasView;
import com.bw.movie.model.utils.HttpUtils;
import com.bw.movie.model.utils.NetUtil;


/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public abstract class BeasActivity <P extends BeasPresent> extends AppCompatActivity implements IBeasView {

    public P present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLyout());
        inttView();
        present = Present();
        if (present !=null){
            present.attchView(this);
        }
        inttData();
        //跳转相机动态权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

    }
    protected  abstract int setLyout();
    protected abstract void inttView();
    protected  abstract P Present();
    protected abstract void inttData();
    public void isdowrk(){
        boolean iswork = NetUtil.hasNetwork(this);
        if (iswork==false){
            Toast.makeText(this, "撒大声地", Toast.LENGTH_SHORT).show();
            //加载布局
            View inflate = LayoutInflater.from(this).inflate(R.layout.iswork, null);
            setContentView(inflate);
          /*  final PopupWindow popWindow = new PopupWindow(inflate,
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
            popWindow.setTouchable(true);
            //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
            popWindow.showAsDropDown(inflate, 50, 0);*/
        }else if (iswork==true){
            setContentView(setLyout());
            inttView();
            present = Present();
            if (present !=null){
                present.attchView(this);
            }
            inttData();
            //跳转相机动态权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
            }

        }
    }

    public int verifyPermissions(Activity activity, java.lang.String permission) {
        int Permission = ActivityCompat.checkSelfPermission(activity,permission);
        if (Permission == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(activity, "已经同意权限", Toast.LENGTH_SHORT).show();
            return 1;
        }else{
            Toast.makeText(activity, "没有同意权限", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.dettchView();
    }
}
