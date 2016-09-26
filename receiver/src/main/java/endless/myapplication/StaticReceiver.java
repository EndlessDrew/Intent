package endless.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;

/**
 * Created by z on 2016/9/17.
 */
public class StaticReceiver extends  BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}