package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.DimmovieBean;
import com.bw.movie.present.DimmoviePresent;
import com.bw.movie.view.adapter.DimovieAdapter;
import com.bw.movie.view.adapter.DirectorAdapter;

import java.util.List;

public class DimmovieActivity extends BeasActivity<DimmoviePresent> implements ICountView.DimmovieView {
    private RecyclerView dime_recy;
    private EditText dime_edit;
    private TextView dime_soy;
    private String trim;
    private ImageView set_back,diem_img;
    @Override
    protected int setLyout() {
        return R.layout.activity_dimmovie;
    }

    @Override
    protected void inttView() {
        dime_edit=findViewById(R.id.dime_edit);
        dime_recy=findViewById(R.id.dime_recy);
        dime_soy=findViewById(R.id.dime_soy);
        set_back=findViewById(R.id.set_back);
        diem_img=findViewById(R.id.diem_img);
        dime_recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected DimmoviePresent Present() {
        return new DimmoviePresent();
    }

    @Override
    protected void inttData() {
        present.dimmovie(trim,0);
        dime_edit.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                trim = dime_edit.getText().toString().trim();
                if (trim !=null){
                    present.dimmovie(trim,5);
                }else {
                    Toast.makeText(DimmovieActivity.this, "请输入", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
 /*       dime_soy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = dime_edit.getText().toString().trim();
                present.dimmovie(trim);
            }
        });*/
        set_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DimmovieActivity.this.finish();
            }
        });

    }

    @Override
    public void DimmovieSucess(DimmovieBean bean) {
        List<DimmovieBean.ResultBean> result = bean.getResult();
        if (result!=null){
            DimovieAdapter adapter=new DimovieAdapter(bean.getResult(),this);
            dime_recy.setAdapter(adapter);
            diem_img.setVisibility(View.GONE);
            dime_recy.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
           // Glide.with(this).load(R.mipmap.n).into(diem_img);
            diem_img.setVisibility(View.VISIBLE);
            dime_recy.setVisibility(View.GONE);
        }

    }
}
