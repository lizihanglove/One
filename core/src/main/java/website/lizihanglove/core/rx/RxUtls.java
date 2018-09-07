package website.lizihanglove.core.rx;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lizihanglove
 * @date 2018/9/7
 * @email one_mighty@163.com
 * @desc
 */
public final class RxUtls {
    private RxUtls() {
    }

    public static <T> ObservableTransformer<T, T> apply() {
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> upstream) {
                Observable<T> observable = upstream
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .debounce(5, TimeUnit.SECONDS)
                        .unsubscribeOn(Schedulers.io());
                return observable;
            }
        };
    }
}
