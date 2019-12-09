package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.R;

public class SetActivity extends AppCompatActivity {
    private ImageView updet,reset,set_back;
    private RelativeLayout quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        updet=findViewById(R.id.updet);
        quit=findViewById(R.id.quit);
        reset=findViewById(R.id.reset);
        set_back=findViewById(R.id.set_back);
        updet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SetActivity.this,UpdateActivity.class);
                startActivity(intent);
            }
        });
        set_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
