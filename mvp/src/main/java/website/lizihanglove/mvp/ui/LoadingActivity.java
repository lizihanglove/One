package website.lizihanglove.mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import site.lizihanglove.loading.Loading;

/**
 * @author lizihanglove
 * @date 2018/8/23
 * @email one_mighty@163.com
 * @desc 含有加载的Activity基类
 */
public abstract class LoadingActivity extends BaseActivity {

    /**
     * 加载动画类
     */
    Loading loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        loading = new Loading.Builder(LoadingActivity.this)
                .setCancelable(true)
                .build();
        super.onCreate(savedInstanceState);

    }

    /**
     * 显示加载动画
     */
    public void showLoading() {
        if (loading == null) {
            throw new IllegalStateException("loading 不能为空");
        }
        loading.show();
    }

    /**
     * 关闭加载动画
     */
    public void dismissLoading() {
        if (loading == null) {
            throw new IllegalStateException("loading 不能为空");
        }
        loading.dismiss();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loading.isShowing()) {
            loading.dismiss();
        }
        loading.cancel();
        loading = null;
    }
}
