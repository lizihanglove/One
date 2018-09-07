package website.lizihanglove.core.net.interceptor;

import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import website.lizihanglove.core.store.SpUtil;

import static website.lizihanglove.core.constant.SpConstant.COOKIE_NAME;

/**
 * @author lizihanglove
 * @date 2018/9/7
 * @email one_mighty@163.com
 * @desc
 */
public class AddCookiesInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> cookies = (HashSet<String>) SpUtil.getStringSet(COOKIE_NAME,null);
        if (cookies != null) {
            for (String cookie : cookies) {
                builder.addHeader("Cookie", cookie);
                Log.v("OkHttp", "Adding Header: " + cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}
