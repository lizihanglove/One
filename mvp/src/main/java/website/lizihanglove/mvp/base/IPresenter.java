package website.lizihanglove.mvp.base;

/**
 * @author lizihanglove
 * @date 2018/8/21
 * @email one_mighty@163.com
 * @desc
 */
public interface IPresenter<T extends IView> {
    void attachView(T t);
    void detachView();
}
