package com.bw.movie.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bw.movie.R;
import com.bw.movie.beas.BeasActivity;
import com.bw.movie.contract.ICountView;
import com.bw.movie.model.bean.BirthdayBean;
import com.bw.movie.model.bean.IUserBean;
import com.bw.movie.model.bean.UploadingBean;
import com.bw.movie.present.UploadingPresent;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MineActivity extends BeasActivity<UploadingPresent> implements ICountView.UploadingView {
    private ImageView set_back,details_back;
    private LinearLayout linearGone,linerPhone,linerPhoneHl;
    private SimpleDraweeView text_my_imag;
    private Button but_photo,but_shoot;
    private TextView textMyName,textMyEmail,textMyPhone,textMyXing,textMyData;
    //需要的权限数组 读/写/相机
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA };
    private int ussid;
    private String ussisnid;

    @Override
    protected int setLyout() {
        return R.layout.activity_mine;
    }

    @Override
    protected void inttView() {
        set_back=findViewById(R.id.set_back);
        details_back=findViewById(R.id.details_back);
        text_my_imag=findViewById(R.id.textimag);
        textMyData=findViewById(R.id.text_my_data);
        linearGone=findViewById(R.id.linear_gone);
        but_shoot=findViewById(R.id.but_shoot);
        textMyName=findViewById(R.id.text_my_name);
       // textMyPhone=findViewById(R.id.text_my_phone);
        textMyEmail=findViewById(R.id.text_my_email);
        textMyXing=findViewById(R.id.text_my_xing);
        but_photo=findViewById(R.id.but_photo);

     //   linerPhone=findViewById(R.id.liner_phone);
        linerPhoneHl=findViewById(R.id.liner_phone_hl);

    }

    @Override
    protected UploadingPresent Present() {
        return new UploadingPresent();
    }

    @Override
    protected void inttData() {
        details_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        textMyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerView mTimePickerView = new TimePickerView(MineActivity.this, TimePickerView.Type.YEAR_MONTH_DAY);

                    // 设置是否循环

                          mTimePickerView.setCyclic(true);

                          // 设置滚轮文字大小

                          //mTimePickerView.set(TimePickerView.TextSize.SMALL);

                          // 设置时间可选范围(结合 setTime 方法使用,必须在)

                          //Calendar calendar = Calendar.getInstance();

                          // mTimePickerView.setRange(calendar.get(Calendar.YEAR) - 100, calendar.get(Calendar.YEAR));

                          // 设置选中时间

                          // mTimePickerView.setTime(new Date());

                          mTimePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

                           @Override

                public  void onTimeSelect(Date date) {
                               SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd",Locale.CHINA);
                               Toast.makeText(MineActivity.this, format.format(date), Toast.LENGTH_SHORT).show();
                            present.birthp(ussid,ussisnid,format.format(date));
                               textMyData.setText(format.format(date));
                           }

                          });

                 mTimePickerView.show();

            }
        });
        textMyXing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OptionsPickerView<String> mOptionsPickerView = new OptionsPickerView(MineActivity.this);
               final ArrayList<String> list = new ArrayList<>();
               list.add("男");
               list.add("女");
               // 设置数据
               mOptionsPickerView.setPicker(list);
               // 设置选项单位
               //mOptionsPickerView.setLabels("性");
               mOptionsPickerView.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                @Override
               public void onOptionsSelect(int option1, int option2, int option3) {
                    String sex = list.get(option1);
                    Toast.makeText(MineActivity.this, sex, Toast.LENGTH_SHORT).show();
                    textMyXing.setText(sex);
                }
                });
                mOptionsPickerView.show();

            }
        });

        SharedPreferences jin = getSharedPreferences("jin", Context.MODE_PRIVATE);
        ussid = jin.getInt("ussid", 0);
        ussisnid = jin.getString("ussisnid", "");
      /*  linerPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linerPhoneHl.setVisibility(View.VISIBLE);
                linerPhone.setVisibility(View.GONE);
            }
        });*/
        text_my_imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearGone.setVisibility(View.VISIBLE);
            }
        });

        // 相机
        but_shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//检查是否已经获得相机的权限
                if(verifyPermissions(MineActivity.this,PERMISSIONS_STORAGE[2]) == 0){
                    ActivityCompat.requestPermissions(MineActivity.this, PERMISSIONS_STORAGE, 3);
                }else{
                    //已经有权限
                    Intent intent = new Intent ( MediaStore.ACTION_IMAGE_CAPTURE );
                    startActivityForResult ( intent,101 );
                }
            }
        });
        but_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);  //跳转到 ACTION_IMAGE_CAPTURE
                intent.setType("image/*");
                startActivityForResult(intent,100);
            }
        });
        present.iuserb(ussid,ussisnid);
    }

    @Override
    public void UploadingSuess(UploadingBean bean) {
        if (bean.getStatus().equals("0000")) {
            Toast.makeText(this, "" + bean.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "" + bean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void IUserSuess(IUserBean bean) {
        IUserBean.ResultBean result = bean.getResult();
        text_my_imag.setImageURI(result.getHeadPic());
        textMyName.setText(result.getNickName());
        textMyEmail.setText(result.getEmail());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd ");
        String format = sdf.format(result.getLastLoginTime());
        textMyData.setText(format);
        int sex = result.getSex();
        if (sex == 1) {
            textMyXing.setText("男");
        } else if (sex == 2) {
            textMyXing.setText("女");
        }

    }

    @Override
    public void BirthdaySun(BirthdayBean bean) {
        String status = bean.getStatus();
        if (status!=null){
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断返回码不等于0
        if (requestCode != RESULT_CANCELED) {
            //读取返回码
            switch (requestCode) {
                case 100:   //相册返回的数据（相册的返回码）
                    Uri uri01 = data.getData();
                    Log.i("aaa", "onActivityResult: "+uri01);
                    String[] str = {MediaStore.Images.Media.DATA};
//                    游标
                    Cursor cursor = getContentResolver ().query ( uri01, str, null, null, null );
//                  如果没有找到该列名,会抛出IllegalArgumentException异常
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow ( MediaStore.Images.Media.DATA );
                    cursor.moveToFirst ();

                    String path = cursor.getString ( columnIndexOrThrow );
                    Log.i("aaa", "onActivityResult: "+path);
//                    文件
                    File file = new File ( path );
//                      创建请求体
                    RequestBody requestBody = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), file );
                    MultipartBody.Part formData = MultipartBody.Part.createFormData ( "image", file.getName (), requestBody );
                    Log.i("aaa", "onActivityResult: "+formData);

                    present.cinema(ussid,ussisnid,formData);

                    linearGone.setVisibility(View.GONE);

                    break;
                case 101:  //相机返回的数据（相机的返回码）
                    try {
                        File file1 = new File(Environment.getExternalStorageDirectory(), "fileImg.jpg");//相机取图片数据文件
                        RequestBody requestBody1 = RequestBody.create ( MediaType.parse ( "multipart/form-data" ), file1 );
                        MultipartBody.Part formData1 = MultipartBody.Part.createFormData ( "image", file1.getName (), requestBody1 );
                        present.cinema(ussid,ussisnid,formData1);

                        linearGone.setVisibility(View.GONE
                        );

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
