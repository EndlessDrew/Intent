package endless.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class AActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 点击视图
     * 通过组件名称启动某个activity
     */
    public void startActivityByComponentName(View view) {
            //申明一个默认的intent
        Intent intent =new Intent( );
        //一个指向系统设置页的组件名，这里表示跳转至手机设置页面
        ComponentName mSetting = new ComponentName(
                "com.android.settings",
                "com.android.settings.Settings"
        );
        //给Intent 设置启动的组件名称（现实intent ）系统设置页、
        intent.setComponent(mSetting);
        startActivity(intent);
    }


    /**
     * 通过启动某个Activity 常用 显式
     * @param view
     */
    public void  startActivityBySetClass(View view){
        //申明一个intent
        Intent  intent  = new Intent( );
        intent.setClass(this ,BActivity.class);
        startActivity(intent);

    }

    /**
     * 通过类名启动
     * @param view
     */

    public  void  startActivityBySetClassName(View view){
        Intent  intent= new Intent( );
        //给intent设置启动类  可以跨application启动  启动设置
        intent.setClassName("com.android.settings","com.android.settings.Settings");
        startActivity(intent);

    }

    /**
     * @description 通过指定Action来隐式启动BActivity
     * @param view 点击的视图
     */
    public void startBActivityByAction(View view) {

        //声明一个默认的intent
        Intent mIntent = new Intent();
        //指定需要匹配的操作
        mIntent.setAction("com.example.intent.MYACTION");

        mIntent.addCategory("android.intent.category.DEFAULT");
//        mIntent.setAction(Intent.ACTION_VIEW);
        //启动这一组件
        startActivity(mIntent);
    }



    /**
     * @description 通过指定Data和MIME来隐式启动某些组件
     * @param view 点击的视图
     */
    public void startActivityByDataAndType(View view){
        //确定图片在设备中的位置
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM + "/Camera"),
                "a.jpg");
        //如果图片存在
        if(file.exists()){
            //返回该文件的URI
            Uri mUri = Uri.fromFile(file);
            //声明一个默认的intent
            Intent mIntent = new Intent();
            //指定需要匹配的操作
            mIntent.setAction(Intent.ACTION_VIEW);
            //设置Intent的Data和MIME类型
            mIntent.setDataAndType(mUri, "image/*");
            //启动这一组件
            startActivity(mIntent);

        }

    }

    /**
     * @description 启动ActivityB,并传递附加信息
     * @param view
     */
    public void startActivityB(View view) {
        //显式指定一个组件
        Intent mIntent = new Intent(this, BActivity.class);
        //需传递的信息
        Bundle mBundle = new Bundle();
        mBundle.putString("Key1", "键1的值");
        mBundle.putString("Key2", "键2的值");
        //将信息组放入Intent中
        mIntent.putExtras(mBundle);
        //启动目标组件
        startActivity(mIntent);
    }

}
