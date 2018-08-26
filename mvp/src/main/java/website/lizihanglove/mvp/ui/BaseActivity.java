package website.lizihanglove.mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author lizihanglove
 * @date 2018/8/22
 * @email one_mighty@163.com
 * @desc Activity 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getCanonicalName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = getLayout();
        Log.i(TAG, "onCreate: "+layout);
        setContentView(layout);
        initView();
    }

    /**
     * 返回布局文件
     * @return R
     */
    public abstract  int getLayout();

    /**
     * 初始化视图
     */
    protected abstract void initView();

}
