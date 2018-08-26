package website.lizihanglove.one.user.presenter;

import website.lizihanglove.mvp.base.IView;
import website.lizihanglove.mvp.presenter.BasePresenter;
import website.lizihanglove.mvp.view.BaseView;

/**
 * @author lizihanglove
 * @date 2018/8/26
 * @email one_mighty@163.com
 * @desc
 */
public class LoginPresenter<LoginView extends BaseView> extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super(view);
    }

    /**
     * 登录操作
     * @param username 
     * @param pwd 
     */
    public void login(String username ,String pwd){
        // TODO: 2018/8/26 登录操作 
    }
    
}
