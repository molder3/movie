package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinemaBean;
import com.bw.movie.model.bean.GuanzhucineBean;
import com.bw.movie.model.bean.QuxiaoguanzBean;
import com.bw.movie.present.CinemaPresent;

/**
 * date:2019/11/14
 * author:金豪(Lenovo)
 * function:
 */
public class CinemaFragementont extends BeasFragment<CinemaPresent> implements ICountView.CinemaView {
    private TextView movie_site,movie_phone,movie_path1;

    @Override
    protected int setLyout() {
        return R.layout.cinemafragmentone;
    }

    @Override
    protected void intiView() {
        movie_phone=getViewId(R.id.movie_phone);
        movie_site=getViewId(R.id.movie_site);
        movie_path1=getViewId(R.id.movie_path1);
    }

    @Override
    protected CinemaPresent setPrsent() {
        return new CinemaPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin = getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        SharedPreferences cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
        int cinemaId = cine.getInt("cinemaId", 0);
        fpresen.cinema(ussid,ussisnid,cinemaId);
    }

    @Override
    public void Sucees(CinemaBean bean) {
          movie_site.setText(bean.getResult().getAddress());
          movie_phone.setText(bean.getResult().getPhone());
          movie_path1.setText(bean.getResult().getVehicleRoute());
    }

    @Override
    public void GuasnzhuSuces(GuanzhucineBean bean) {

    }

    @Override
    public void QuxiaoSucess(QuxiaoguanzBean bean) {

    }
}
