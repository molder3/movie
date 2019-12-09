package com.bw.movie.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.down_load.DownUtils;
import com.bw.movie.present.BannerPresent;

public class UpdateActivity extends BeasActivity implements DownUtils.onProgress{
    private Button button_update, button_stop;
    private ProgressBar progress_bar;
    private DownUtils downUtils;
    private TextView text;
    private ImageView set_back;
    private int i = 0;


    private void stop() {
        if (i % 2 == 0) {
            downUtils.onPause();
            button_stop.setText("继续下载");
        } else {
            downUtils.onRestart();
            button_stop.setText("暂停下载");
        }
        i++;
    }

    private void start() {
        downUtils.onStart();
        button_update.setText("正在下载");
        button_update.setClickable(false);
    }

    @Override
    public void onProgress(long size, long length, boolean isSu) {
        int down_size = (int) (100 * size / length);
        progress_bar.setProgress(down_size);
        text.setText(down_size + "");
    }

    @Override
    protected int setLyout() {
        return R.layout.activity_update;
    }

    @Override
    protected void inttView() {
        progress_bar = findViewById(R.id.progress_bar);
        button_update = findViewById(R.id.button_update);
        button_stop = findViewById(R.id.button_stop);
        set_back = findViewById(R.id.set_back);
        text = findViewById(R.id.text);
    }

    @Override
    protected BeasPresent Present() {
        return new BannerPresent();
    }

    @Override
    protected void inttData() {
            downUtils = DownUtils.getInstance();
            downUtils.setOnProgress(this);
            button_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stop();
                    button_stop.setVisibility(View.VISIBLE);

                }
            });
            button_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    start();
                    button_update.setVisibility(View.INVISIBLE);
                    button_stop.setVisibility(View.VISIBLE);
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
