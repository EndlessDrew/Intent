package com.intentactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends Activity {
    //测试请求码
    private final int REQUEST_CODE_LOGIN = 0;
    private final int REQUEST_CODE_REGIST = 1;
    private final int REQUEST_CODE_OTHER = 2;
    TextView  tv_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        tv_data =(TextView)findViewById(R.id.tv_data);
    }
    //数据显示控件
    //当前Activity标志
    public static final String TAG = "SecondActivity";



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //判断返回码和请求码码
        switch (resultCode){

            case Activity.RESULT_OK://处理成功
                switch (requestCode){
                    case REQUEST_CODE_LOGIN:
                        //更新UI
                        tv_data.setText(data.getStringExtra(SecondActivity.TAG));
                        break;
                    case REQUEST_CODE_REGIST:
                        //更新UI
                        tv_data.setText(data.getStringExtra(SecondActivity.TAG));
                        break;
                }
                break;
            case Activity.RESULT_CANCELED://处理失败或者取消
                //更新UI
                tv_data.setText(data.getStringExtra(SecondActivity.TAG));
                break;
        }

    }


    /**
     * @description 模拟登陆操作
     * @param view 点击的视图
     */
    public void Login(View view) {
        //显示指定启动一个activity的intent
        Intent mIntent = new Intent(this, SecondActivity.class);
        //模拟一个登陆操作
        mIntent.putExtra(TAG, "Login");
        //启动返回结果的Activity
        startActivityForResult(mIntent, REQUEST_CODE_LOGIN);
    }


    /**
     * @description 模拟注册操作
     * @param view 点击的视图
     */
    public void Regist(View view) {
        //显示指定启动一个activity的intent
        Intent mIntent = new Intent(this, SecondActivity.class);
        //模拟一个登陆操作
        mIntent.putExtra(TAG, "Regist");
        //启动返回结果的Activity
        startActivityForResult(mIntent, REQUEST_CODE_REGIST);
    }

    /**
     * @description 模拟其他操作
     * @param view 点击的视图
     */
    public void Other(View view) {
        //显示指定启动一个activity的intent
        Intent mIntent = new Intent(this, SecondActivity.class);
        //模拟一个登陆操作
        mIntent.putExtra(TAG, "Other");
        //启动返回结果的Activity
        startActivityForResult(mIntent, REQUEST_CODE_OTHER);
    }
}

