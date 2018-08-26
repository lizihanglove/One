package website.lizihanglove.mvp.ui;

import javax.inject.Inject;

import website.lizihanglove.mvp.presenter.BasePresenter;

/**
 * @author lizihanglove
 * @date 2018/8/26
 * @email one_mighty@163.com
 * @desc MVP架构activity基类
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends LoadingActivity {
    @Inject
    public T presenter;
    public abstract T getPresenter( BaseMvpActivity activity );

}
