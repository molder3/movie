package com.bw.movie.view.activity.loginregister;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.encrypt.EncryptUtil;
import com.bw.movie.model.bean.CodeBean;
import com.bw.movie.model.bean.loginregister.RegisterBean;
import com.bw.movie.present.loginregister.RegisterPresent;

public class RegisterActivity extends BeasActivity<RegisterPresent> implements ICountView.RegisterView{
    private EditText rgi_name,rgi_you,rgi_mi,rgi_yanzheng;
    private Button ring_note,ring_de;
    private TextView text_deng;

    @Override
    protected int setLyout() {
        return R.layout.activity_register;
    }

    @Override
    protected void inttView() {
        rgi_name=findViewById(R.id.ring_name);
        rgi_mi=findViewById(R.id.ring_mi);
        rgi_you=findViewById(R.id.ring_you);
        rgi_yanzheng=findViewById(R.id.ring_yanzhe);
        ring_note=findViewById(R.id.ring_note);
        ring_de=findViewById(R.id.ring_de);
        text_deng=findViewById(R.id.ring_deng);
    }

    @Override
    protected RegisterPresent Present() {
        return new RegisterPresent();
    }

    @Override
    protected void inttData() {
     isdowrk();

        //注册
        ring_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String niche = rgi_name.getText().toString().trim();
                String mima = rgi_mi.getText().toString().trim();
                String youx = rgi_you.getText().toString().trim();
                String yanz = rgi_yanzheng.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(mima);

                present.regiser(niche,encrypt,youx,yanz);
            }
        });
        //发送
        ring_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String youx = rgi_you.getText().toString().trim();
                if (youx.length()==0){
                    Toast.makeText(RegisterActivity.this, "请输入邮箱", Toast.LENGTH_SHORT).show();
                }
                present.noted(youx);
            }
        });
        //登录
        text_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void Succeed(RegisterBean bean) {
        if (bean!=null){
            Toast.makeText(this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())){
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void Succee(CodeBean bean) {
        if (bean!=null){
            Toast.makeText(this,bean.getMessage(), Toast.LENGTH_SHORT).show();
            if ("0000".equals(bean.getStatus())){

            }
        }
    }
}
