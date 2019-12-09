package com.bw.movie.beas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.contract.IBeasView;

import org.devio.takephoto.app.TakePhotoActivity;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public abstract class BeasActivityss<P extends BeasPresent> extends TakePhotoActivity implements IBeasView {
    public P present;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLyout());
        inttView();
        present = Present();
        present.attchView(this);
        inttData();
    }
    protected  abstract int setLyout();
    protected abstract void inttView();
    protected  abstract P Present();
    protected abstract void inttData();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.dettchView();
    }
}
