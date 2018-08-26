package website.lizihanglove.one.user.ui;

import website.lizihanglove.mvp.presenter.BasePresenter;
import website.lizihanglove.mvp.ui.BaseMvpActivity;
import website.lizihanglove.one.R;

/**
 * @author lizihanglove
 * @date 2018/8/26
 * @email one_mighty@163.com
 * @desc
 */
public class LoginActivity<LoginPresenter extends BasePresenter> extends BaseMvpActivity<LoginPresenter> {


    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public LoginPresenter getPresenter(BaseMvpActivity activity) {

        return presenter;
    }

    @Override
    protected void initView() {

    }


}
