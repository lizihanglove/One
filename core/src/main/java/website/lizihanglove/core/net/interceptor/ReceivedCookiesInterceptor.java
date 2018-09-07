package website.lizihanglove.core.net.interceptor;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;
import website.lizihanglove.core.store.SpUtil;

import static website.lizihanglove.core.constant.SpConstant.COOKIE_NAME;

/**
 * @author lizihanglove
 * @date 2018/9/7
 * @email one_mighty@163.com
 * @desc 请求返回cookie时，保存cookie
 */
public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }
            SpUtil.putStringSet(COOKIE_NAME,cookies);
        }
        return originalResponse;
    }
}
