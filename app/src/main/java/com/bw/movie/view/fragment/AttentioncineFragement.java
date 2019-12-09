package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CineGuanzBean;
import com.bw.movie.model.bean.QuxiaoguanzBean;
import com.bw.movie.present.CineLikePresent;
import com.bw.movie.view.adapter.CineLikeAdapter;
import com.bw.movie.view.adapter.CinePinAdapter;

import java.util.List;

/**
 * date:2019/12/1
 * author:金豪(Lenovo)
 * function:
 */
public class AttentioncineFragement extends BeasFragment<CineLikePresent> implements ICountView.CineLikeView {
    private RecyclerView guanzhuciene_recy;
    private int cinemaId;
    private String ussisnid;
    private int ussid;
    private CineLikeAdapter adapter;
    private ImageView sda;
    @Override
    protected int setLyout() {
        return R.layout.attentioncine;
    }

    @Override
    protected void intiView() {
        guanzhuciene_recy=getViewId(R.id.guanzhuciene_recy);
        sda=getViewId(R.id.sda);
        guanzhuciene_recy.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected CineLikePresent setPrsent() {
        return new CineLikePresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin = getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
        SharedPreferences cine = getActivity().getSharedPreferences("cine", Context.MODE_PRIVATE);
      //  cinemaId = cine.getInt("cinemaId", 0);
        fpresen.cinelike(ussid, ussisnid);
    }

    @Override
    public void CoinelikeSUcess(CineGuanzBean bean) {
        List<CineGuanzBean.ResultBean> result = bean.getResult();
        if (result!=null){
            adapter = new CineLikeAdapter(bean.getResult(),getActivity());
            guanzhuciene_recy.setAdapter(adapter);
            adapter.setOnckiletedf(new CineLikeAdapter.Onckiletedf() {
                @Override
                public void Onckiled(int cinemaId) {
                    fpresen.quxiaoguanzh(ussid,ussisnid,cinemaId);
                }

                @Override
                public void Ondksad(int i) {
                    result.remove(i);
                    adapter.notifyItemRemoved(i);
                    adapter.notifyItemRangeChanged(i,result.size());
                }
            });
        }else {
            sda.setVisibility(View.VISIBLE);
            fpresen.quxiaoguanzh(ussid,ussisnid,cinemaId);
        }

    }

    @Override
    public void QuxiaoSucess(QuxiaoguanzBean bean) {

       if (bean.getStatus().equals("0000")){
           adapter.notifyDataSetChanged();
       }
    }
}
