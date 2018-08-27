package website.lizihanglove.core.net.api;

import java.io.Serializable;

/**
 * @author lizihanglove
 * @date 2018/8/27
 * @email one_mighty@163.com
 * @desc
 */
public class Api<T> implements Serializable {
    Class<T> serverApi;
    String baseUrl;

    /**
     * 构造方法
     *
     * @param serverApi 服务器接口集合
     * @param baseUrl   服务器基本地址
     */
    public Api(Class<T> serverApi, String baseUrl) {
        this.serverApi = serverApi;
        this.baseUrl = baseUrl;
    }

    public Class<T> getServerApi() {
        return serverApi;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}

