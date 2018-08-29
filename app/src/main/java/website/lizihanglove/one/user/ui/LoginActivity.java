package website.lizihanglove.one.user.ui;

import android.support.v7.app.ActionBar;

import website.lizihanglove.mvp.ui.BaseMvpActivity;
import website.lizihanglove.one.R;
import website.lizihanglove.one.user.presenter.LoginPresenter;
import website.lizihanglove.one.user.view.LoginView;

/**
 * @author lizihanglove
 * @date 2018/8/26
 * @email one_mighty@163.com
 * @desc
 */
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginView {

    @Override
    public int getLayout() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        //presenter.login();
    }


}
