package com.bw.movie.beas;

import com.bw.movie.contract.IBeasView;

/**
 * date:2019/11/11
 * author:金豪(Lenovo)
 * function:
 */
public class BeasPresent<V extends IBeasView> {
    private V miBeasView;
    //邦定
    public void attchView(V iBeasView){
        this.miBeasView=iBeasView;
    }
    //解绑
    public void dettchView(){
        this.miBeasView=null;
    }
    //获取
    public V getView(){
        return miBeasView;
    }
}
