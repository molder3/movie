package com.bw.movie.view.activity.loginregister;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.MyApplication;
import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.encrypt.EncryptUtil;
import com.bw.movie.model.bean.WxBean;
import com.bw.movie.model.bean.loginregister.LoginBean;
import com.bw.movie.model.utils.HttpUtils;
import com.bw.movie.present.loginregister.LoginPresent;
import com.bw.movie.view.activity.HomeActivity;
import com.bw.movie.view.activity.MainActivity;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.UUID;

public class LoginActivity extends BeasActivity<LoginPresent> implements ICountView.LoginView{

    private EditText zhang,mi;
    private Button forget,de,wei;
    private TextView register;
    private ImageView imageView;
    private SharedPreferences.Editor edit;
    private SharedPreferences jin;
    @Override
    protected int setLyout() {
        return R.layout.activity_login;
    }
    //注册
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
    @Override
    protected void inttView() {
        jin = getSharedPreferences("jin", Context.MODE_PRIVATE);
        edit = jin.edit();
        zhang=findViewById(R.id.lon_zhang);
        mi=findViewById(R.id.lon_mi);
        forget=findViewById(R.id.lon_forget);
        de=findViewById(R.id.lon_de);
        wei=findViewById(R.id.lon_wei);
        register=findViewById(R.id.lon_register);

    }

    @Override
    protected LoginPresent Present() {
        return new LoginPresent();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void EventBusReceiver(String code){
       /* Log.i("xxx", "EventBusReceiver: "+code);
        Toast.makeText(this, ""+code, Toast.LENGTH_SHORT).show();*/
        present.Wxde(code);
    }
    @Override
    protected void inttData() {

        boolean iswork = HttpUtils.getUtls().iswork(this);
        if (iswork){
//登录
            de.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emid = zhang.getText().toString().trim();
                    String pw = mi.getText().toString().trim();
                    String encrypt = EncryptUtil.encrypt(pw);
                    present.Login(emid,encrypt);
                }
            });
            //注册
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });
        }else {
            Toast.makeText(this, "无网", Toast.LENGTH_SHORT).show();
            // Glide.with(this).load(R.drawable.wuw).into(imageView);
        }
        wei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               wxlong();
            }
        });
    }

    @Override
    public void Sucess(LoginBean bean) {
        if (bean!=null){
            Toast.makeText(this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())){
                LoginBean.ResultBean result = bean.getResult();
                edit.putInt("ussid",result.getUserId());
                edit.putString("ussisnid",result.getSessionId());
                edit.commit();

                Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void WxSucess(WxBean bean) {
        if (bean!=null){
            Toast.makeText(this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())){
                WxBean.ResultBean result = bean.getResult();
                edit.putInt("ussid",result.getUserId());
                edit.putString("ussisnid",result.getSessionId());
                edit.commit();
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        }
    }
    public void wxlong(){
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = UUID.randomUUID().toString();
        MyApplication.getWXApi().sendReq(req);;
    }
    //解
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
