package endless;

import android.app.Activity;
import android.os.Bundle;

import endless.mdzz.R;

/**
 * Created by z on 2016/9/14.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContent());
    }

    protected abstract int setContent();
    protected abstract  void initView();
    protected abstract  void setListener();

}
