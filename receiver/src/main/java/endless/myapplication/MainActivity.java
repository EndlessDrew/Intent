package endless.myapplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button sendStaticBtn;
    private Button sendDynamicBtn;
    private Button sendSystemBtn;

    private static final String STATICACTION = "endless.myapplication.static";
    private static final String DYNAMICATION = "endless.myapplication.dynamic";
    //USB设备连接
    private static final String SYSTEMACTION = Intent.ACTION_POWER_CONNECTED;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendStaticBtn = (Button) findViewById(R.id.send_static);
        sendDynamicBtn = (Button) findViewById(R.id.send_dynamic);
        sendSystemBtn = (Button) findViewById(R.id.send_system);
        sendStaticBtn.setOnClickListener(new MyOnClickListener());
        sendDynamicBtn.setOnClickListener(new MyOnClickListener());
        sendSystemBtn.setOnClickListener(new MyOnClickListener());

    }


    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //发送自定义静态注册广播消息
            if (view.getId() == R.id.send_static) {
                Log.e("aa", "发送自定义静态注册广播消息");
                Intent intent = new Intent();
                intent.setAction(STATICACTION);
                intent.putExtra("msg", "接收静态注册广播成功");
                sendBroadcast(intent);
            } else if (view.getId() == R.id.send_dynamic) {
                //发送自定义动态注册广播消息
                Log.e("aa", "发送自定义动态注册广播消息");
                Intent intent = new Intent();
                intent.setAction(DYNAMICATION);
                intent.putExtra("msg", "接收动态注册广播");
                sendBroadcast(intent);
            }
            //发送系统动态注册广播消息，手机连接充电设备时，会有系统自己发送广播消息
            else if (view.getId() == R.id.send_system) {
                Intent intent = new Intent();
                intent.setAction(SYSTEMACTION);
                intent.putExtra("msg", "正在充电·····");

            }
        }
    }
    protected void onStart(){
        super.onStart();
        Log.e("aa","注册广播事件");
        IntentFilter flater_dynamic = new IntentFilter();
        flater_dynamic.addAction(DYNAMICATION);
        registerReceiver(dynamicReceiver ,flater_dynamic);

        IntentFilter filter_system = new IntentFilter();
        registerReceiver(systemReceiver,filter_system);
    }
    private BroadcastReceiver dynamicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(DYNAMICATION)){
                String msg = intent.getStringExtra( "msg");
                Toast.makeText(context ,msg,Toast.LENGTH_SHORT).show();
            }
        }
    };

    private  BroadcastReceiver systemReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(SYSTEMACTION)){
                String msg = intent .getStringExtra("msg");
                Toast.makeText(context , msg,Toast.LENGTH_SHORT).show();
            }
        }
    };

}