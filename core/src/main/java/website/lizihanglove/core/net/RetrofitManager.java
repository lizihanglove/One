package website.lizihanglove.core.net;



import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import website.lizihanglove.core.net.api.Api;
import website.lizihanglove.core.net.api.ServerApi;
import website.lizihanglove.core.net.option.Option;

/**
 * @author lizihanglove
 * @email one_mighty@163.com
 * @date 2017-12-06
 * @time 10:07
 * @desc 网络请求管理类
 */

public class RetrofitManager {
    private static RetrofitManager mRetrofitManager;
    private static ArrayList<Api> mServers;
    private static Retrofit.Builder mRetrofitBuilder;

    private RetrofitManager() {

    }

    /**
     * 创建网络请求
     *
     * @param api 服务器与接口参数类
     * @return 返回网络接口对应的请求类
     */
    private <T> T createRequest(Api<T> api) {
        T t = mRetrofitBuilder
                .baseUrl(api.getBaseUrl())
                .build()
                .create(api.getServerApi());
        return t;

    }

    /**
     * 获取默认服务器网络请求接口对应的类
     *
     * @return 服务器网络请求接口对应的类
     */
    public ServerApi getServer() {
        if (null != mRetrofitManager) {
            Api<ServerApi> api = mServers.get(0);
            return createRequest(api);
        } else {
            throw new IllegalStateException("RetrofitManager暂时没有初始化！");
        }
    }

    /**
     * 创建第三方服务器请求
     *
     * @param api 服务器接口集合接口
     * @param <T> 服务器接口集合接口泛型
     * @return 返回服务器请求
     */
    public <T> T getOtherServer(Api<T> api) {
        return createRequest(api);
    }

    /**
     * 返回线程安全的单例
     *
     * @return RetrofitManager单例
     */
    public static synchronized RetrofitManager getInstance() {
        if (null == mRetrofitManager) {
            synchronized (RetrofitManager.class) {
                if (null == mRetrofitManager) {
                    mRetrofitManager = new RetrofitManager();
                }
            }
        }
        return mRetrofitManager;
    }

    /**
     * 在自定义Application中初始化
     */
    public static void init(Option option) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(option.getConnectTimeout(), TimeUnit.SECONDS);
        builder.readTimeout(option.getReadTimeout(), TimeUnit.SECONDS);
        builder.writeTimeout(option.getWriteTimeout(), TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(option.isRetry());
        OkHttpClient okHttpClient = builder.build();

        mRetrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);
        mServers = option.getServers();
    }
}