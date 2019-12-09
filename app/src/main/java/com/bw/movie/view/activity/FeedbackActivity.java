package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.FeedBackBean;
import com.bw.movie.present.FeedbackPresent;

public class FeedbackActivity extends BeasActivity<FeedbackPresent> implements ICountView.FeedbakView {
    private EditText edti_txt;
    private ImageView details_back;
    private Button tijao;
    private int ussid;
    private String ussisnid;
    private LinearLayout lyasod;
    private RelativeLayout erxds;
    @Override
    protected int setLyout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void inttView() {
      edti_txt=findViewById(R.id.edti_txt);
        details_back=findViewById(R.id.details_back);
        tijao=findViewById(R.id.tijao);
        lyasod=findViewById(R.id.lyasod);
        erxds=findViewById(R.id.erxds);
    }

    @Override
    protected FeedbackPresent Present() {
        return new FeedbackPresent();
    }

    @Override
    protected void inttData() {
          details_back.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  finish();
              }
          });
        SharedPreferences jin =getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
        tijao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = edti_txt.getText().toString().trim();
              if (trim.isEmpty()){
                    Toast.makeText(FeedbackActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    present.feedback(ussid,ussisnid,trim);
                  lyasod.setVisibility(View.VISIBLE);
                  edti_txt.setVisibility(View.INVISIBLE);
                  erxds.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void FeedSuess(FeedBackBean bean) {
        if (bean!=null){
            Toast.makeText(FeedbackActivity.this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
