package website.lizihanglove.core.net.option;

import java.io.Serializable;
import java.util.ArrayList;

import website.lizihanglove.core.net.api.Api;

/**
 * @author lizihanglove
 * @date 2018/8/27
 * @email one_mighty@163.com
 * @desc
 */

public class Option implements Serializable {
    long connectTimeout;
    long readTimeout;
    long writeTimeout;
    boolean retry;
    /**
     * 基于两个服务器的地址列表
     */
    ArrayList<Api> servers = new ArrayList<Api>(2);


    /**
     * 网络配置类私有构造方法
     *
     * @param origin 原始构造对象
     */
    private Option(Option origin) {
        this.connectTimeout = origin.connectTimeout;
        this.readTimeout = origin.readTimeout;
        this.writeTimeout = origin.writeTimeout;
        this.retry = origin.retry;
        this.servers = origin.servers;
    }

    /**
     * 私有空构造方法
     */
    private Option() {

    }

    /**
     * 获取连接超时时间
     *
     * @return 超时时间
     */
    public long getConnectTimeout() {
        return connectTimeout;
    }


    /**
     * 获取读取超时时间
     *
     * @return 超时时间
     */
    public long getReadTimeout() {
        return readTimeout;
    }

    /**
     * 获取写入超时时间
     *
     * @return 超时时间
     */
    public long getWriteTimeout() {
        return writeTimeout;
    }


    /**
     * 获取重试参数
     *
     * @return 重试与否 true:重试；false：不重试
     */
    public boolean isRetry() {
        return retry;
    }

    /**
     * 获取服务器地址集合
     * @return 服务器地址集合
     */
    public ArrayList<Api> getServers() {
        return servers;
    }

    /**
     * 构建者类
     */
    public static class Builder {
        private Option target;

        /**
         * 设置连接超时时间
         *
         * @param timeout 超时时间
         * @return 需要构建的原始对象
         */
        public Builder setConnectTimeout(long timeout) {
            target.connectTimeout = timeout;
            return this;
        }

        /**
         * 设置读取超时时间
         *
         * @param timeout 超时时间
         * @return 需要构建的原始对象
         */
        public Builder setReadTimeout(long timeout) {
            target.readTimeout = timeout;
            return this;
        }

        /**
         * 设置写入超时时间
         *
         * @param timeout 超时时间
         * @return 需要构建的原始对象
         */
        public Builder setWriteTimeout(long timeout) {
            target.writeTimeout = timeout;
            return this;
        }

        /**
         * 设置是否重试
         *
         * @param retry 重试与否 true:重试；false：不重试
         * @return 需要构建的原始对象
         */
        public Builder retry(boolean retry) {
            target.retry = retry;
            return this;
        }


        /**
         * 设置服务器常用基址
         *
         * @param servers 默认是两个基本地址，第一个默认为常用服务器地址，第二个默认为第三方地址，
         *                请正确配置
         * @return 需要构建的原始对象
         */
        public Builder setServers(ArrayList<Api> servers) {
            target.servers = servers;
            return this;
        }

        /**
         * 真正构建目标对象
         *
         * @return 目标对象
         */
        public Option build() {
            return new Option(target);
        }
    }
}
