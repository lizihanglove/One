package website.lizihanglove.one.user.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import website.lizihanglove.one.R;
import website.lizihanglove.mvp.ui.FullScreenActivity;

/**
 * @author lizihanglove
 * @date 2018/8/22
 * @email one_mighty@163.com
 * @desc 闪屏页
 */
public class SplashActivity extends FullScreenActivity {
    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void initView() {
        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "initView: " + R.layout.activity_splash);
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        });
        Log.i(TAG, "initView: " + R.layout.activity_splash);
    }

    @Override
    public int getLayout() {
        Log.i(TAG, "getLayout: " + R.layout.activity_splash);
        return R.layout.activity_splash;
    }
}
