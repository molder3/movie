package com.bw.movie.wxapi;








import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.MyApplication;
import com.bw.movie.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

	private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

	private IWXAPI api;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.pay_result);


		MyApplication.getWXApi().handleIntent(getIntent(), this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp resp) {
		Log.d("TAG", "Luke = " + resp.toString());

		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			int code = resp.errCode;
			switch (code) {
				case 0:
					Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
					break;
				case -1:
					Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
					finish();
					break;
				case -2:
					Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
					finish();
					break;
				default:
					Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();
					setResult(RESULT_OK);
					finish();
					break;
			}
		}
	}
}