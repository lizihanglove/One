package website.lizihanglove.one.user.ui;

import website.lizihanglove.mvp.presenter.BasePresenter;
import website.lizihanglove.mvp.ui.BaseMvpActivity;

/**
 * @author lizihanglove
 * @date 2018/8/26
 * @email one_mighty@163.com
 * @desc
 */
public class RegisterActivity<RegisterPresenter extends BasePresenter> extends BaseMvpActivity<RegisterPresenter> {


    @Override
    public int getLayout() {
        return 0;
    }

    @Override
    public RegisterPresenter getPresenter(BaseMvpActivity activity) {
        return null;
    }

    @Override
    protected void initView() {

    }
}
