package website.lizihanglove.core.convert;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lizihanglove
 * @email one_mighty@163.com
 * @date 2018-8-26
 * @time 20:14
 * @desc Md5加密工具类
 */
public final class MD5Util {

    /**
     * 流缓存长度
     */
    private static final int STREAM_BUFFER_LENGTH = 1024;

    /**
     * 获取消息文摘
     *
     * @param algorithm 算法名称
     * @return 消息文摘
     * @throws NoSuchAlgorithmException 没有该算法异常
     */
    public static MessageDigest getDigest(final String algorithm) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(algorithm);
    }

    /**
     * MD5加密
     *
     * @param txt 待加密文本
     * @return MD5值
     */
    public static byte[] md5(String txt) {
        return md5(txt.getBytes());
    }

    /**
     * MD5加密
     *
     * @param txt 待加密文本
     * @return MD5值转换16位的字符串
     */
    public static String md5HexString(String txt) {
        byte[] bytes = md5(txt.getBytes());
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            if ((b & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }

    /**
     * MD5加密
     *
     * @param bytes 待加密文本byte数组
     * @return MD5值
     */
    public static byte[] md5(byte[] bytes) {
        try {
            MessageDigest digest = getDigest("MD5");
            digest.update(bytes);
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * MD5加密
     *
     * @param is 输入流
     * @return MD5值
     * @throws NoSuchAlgorithmException 没有该算法异常
     * @throws IOException              IO操作流异常
     */
    public static byte[] md5(InputStream is) throws NoSuchAlgorithmException, IOException {
        return updateDigest(getDigest("MD5"), is).digest();
    }

    /**
     * 更新消息文摘
     *
     * @param digest 消息文摘
     * @param data   输入流
     * @return 消息文摘
     * @throws IOException IO操作流异常
     */
    public static MessageDigest updateDigest(final MessageDigest digest, final InputStream data) throws IOException {
        final byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
        int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);

        while (read > -1) {
            digest.update(buffer, 0, read);
            read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
        }
        return digest;
    }
}