package com.bw.movie.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.bw.movie.Constants;
import com.bw.movie.MyApplication;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import org.greenrobot.eventbus.EventBus;


public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getWXApi().handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {
    }

    @Override
    public void onResp(BaseResp baseResp) {
        //登录回调
        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                String code = ((SendAuth.Resp) baseResp).code;
                //eventbus发送
                //获取accesstoken
               EventBus.getDefault().postSticky(code);
                break;
             //用户拒绝授权
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                finish();
                break;
            //用户取消
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                finish();
                break;
            default:
                finish();
                break;
        }


    }

//    private void getAccessToken(String code) {
//        //获取授权
//        StringBuffer loginUrl = new StringBuffer();
//        loginUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token")
//                .append("?appid=")
//                .append("wx45ccf8958a0a24c7")
//                .append("&secret=")
//                .append("e9c071f3326663856bc6cf02c2d6b657")
//                .append("&code=")
//                .append(code)
//                .append("&grant_type=authorization_code");
//        Log.d("urlurl", loginUrl.toString());
//
//        OkHttpClient okHttpClient = new OkHttpClient();
//        final Request request = new Request.Builder()
//                .url(loginUrl.toString())
//                .get()//默认就是GET请求，可以不写
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.d("fan12", "onFailure: ");
//                mProgressDialog.dismiss();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String responseInfo = response.body().string();
//                Log.d("fan12", "onResponse: " + responseInfo);
//                String access = null;
//                String openId = null;
//                try {
//                    JSONObject jsonObject = new JSONObject(responseInfo);
//                    access = jsonObject.getString("access_token");
//                    openId = jsonObject.getString("openid");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                getUserInfo(access, openId);
//            }
//        });
//    }
}
