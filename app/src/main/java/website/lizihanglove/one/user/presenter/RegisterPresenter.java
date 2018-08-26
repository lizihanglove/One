package website.lizihanglove.one.user.presenter;

import website.lizihanglove.mvp.presenter.BasePresenter;
import website.lizihanglove.mvp.view.BaseView;
import website.lizihanglove.one.user.view.LoginView;

/**
 * @author lizihanglove
 * @date 2018/8/26
 * @email one_mighty@163.com
 * @desc
 */
public class RegisterPresenter< RegisterView extends BaseView> extends BasePresenter<RegisterView> {

    public RegisterPresenter(RegisterView view) {
        super(view);
    }

    /**
     * 注册操作
     * @param username 
     * @param pwd 
     */
    public void register(String username ,String pwd){
        // TODO: 2018/8/26 注册操作
    }
    
}
