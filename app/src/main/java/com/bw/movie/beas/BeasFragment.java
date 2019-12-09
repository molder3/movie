package com.bw.movie.beas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.movie.contract.IBeasView;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public abstract class BeasFragment <F extends BeasPresent> extends Fragment implements IBeasView {
    public F fpresen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(setLyout(), container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intiView();
        fpresen = setPrsent();
        fpresen.attchView(this);
        intiData();
    }
    protected  abstract int setLyout();
    protected  abstract void intiView();
    protected  abstract F setPrsent();
    protected  abstract void intiData();
    public <T extends View> T getViewId(int id) {
        return getView().findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fpresen.dettchView();
    }
}
