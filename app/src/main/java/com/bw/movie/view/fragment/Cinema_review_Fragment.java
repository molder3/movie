package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.beas.BeasFragment;
import com.bw.movie.beas.BeasPresent;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.CinemaPingBean;
import com.bw.movie.present.CinemapPresent;
import com.bw.movie.view.adapter.Cinema_review_Adapter;

import java.util.List;

/**
 * date:2019/12/4
 * author:金豪(Lenovo)
 * function:
 */
public class Cinema_review_Fragment extends BeasFragment<CinemapPresent> implements ICountView.CinemaPiView {
    private RecyclerView erxfe;
    @Override
    protected int setLyout() {
        return R.layout.cinema_review_fragmenttwo;
    }

    @Override
    protected void intiView() {
        erxfe= (RecyclerView) getViewId(R.id.erxfe1);
        erxfe.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected CinemapPresent setPrsent() {
        return new CinemapPresent();
    }

    @Override
    protected void intiData() {
        SharedPreferences jin =getActivity().getSharedPreferences("jin", Context.MODE_PRIVATE);
        int ussid = jin.getInt("ussid", 0);
        String ussisnid = jin.getString("ussisnid", "");
        fpresen.cinemap(ussid,ussisnid);
    }

    @Override
    public void CinemaSuess(CinemaPingBean bean) {
        List<CinemaPingBean.ResultBean> status = bean.getResult();
        if (status!=null){
            Cinema_review_Adapter adapter=new Cinema_review_Adapter(bean.getResult(),getActivity());
            erxfe.setAdapter(adapter);
        }

    }
}
