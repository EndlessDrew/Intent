package endless.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by z on 2016/9/17.
 */

public class SystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_BATTERY_LOW)){
            Toast.makeText(context,"您的手机电量偏低，请及时充电",Toast.LENGTH_SHORT).show();

        }
    }
}
