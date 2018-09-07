package website.lizihanglove.core.store;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

import website.lizihanglove.core.constant.SpConstant;

/**
 * @author lizihanglove
 * @email one_mighty@163.com
 * @date 2018-8-26
 * @time 20:14
 * @desc 存储键值对工具类
 */

public final class SpUtil {

    private static Context mContext;
    private static SharedPreferences sp;
    private static SpUtil instance;
    private static SharedPreferences.Editor editor;

    /**
     * 工具类初始化方法，该方法应该在自定义Application中使用。
     *
     * @param context 应用上下文，为防止内存泄露，请使用Application级别的Context
     */
    public static void init(Context context) {
        instance = new SpUtil(context);
    }

    /**
     * 标识SpUtil是否初始化的方法
     *
     * @return SpUtil初始化状态
     */
    public static boolean isInit() {
        return instance != null;
    }


    /**
     * SpUtils构造函数
     * @param context 应用上下文，为防止内存泄露，请使用Application级别的Context
     */
    private SpUtil(Context context) {
        mContext = context.getApplicationContext();
        if (mContext != null) {
            sp = mContext.getSharedPreferences(SpConstant.SP_NAME, Context.MODE_PRIVATE);
            editor = sp.edit();
        } else {
            throw new IllegalStateException("上下文不能为空！");
        }
    }

    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putString(String key, String value) {
        if (null != editor) {
            editor.putString(key, value).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.putString(key, value).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }

    }

    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putInt(String key, int value) {
        if (null != editor) {
            editor.putInt(key, value).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.putInt(key, value).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }

    }

    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putBoolean(String key, boolean value) {
        if (null != editor) {
            editor.putBoolean(key, value).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.putBoolean(key, value).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }

    }

    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putLong(String key, long value) {
        if (null != editor) {
            editor.putLong(key, value).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.putLong(key, value).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }

    }

    /**
     * SP中写入String类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putFloat(String key, float value) {
        if (null != editor) {
            editor.putFloat(key, value).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.putFloat(key, value).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }

    }

    /**
     * SP中写入StringSet类型value
     *
     * @param key   键
     * @param value 值
     */
    public static void putStringSet(String key, Set<String> value) {
        if (null != editor) {
            editor.putStringSet(key, value).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.putStringSet(key, value).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }
    }

    /**
     * SP中读取String
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值
     */
    public static String getString(String key) {
        return getString(key, "");
    }

    /**
     * SP中读取String
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static String getString(String key, String defaultValue) {
        if (null != sp) {
            return sp.getString(key, defaultValue);
        } else {
            throw new UnsupportedOperationException("SharePreference不能为空！请初始化该类！");
        }
    }

    /**
     * SP中读取int
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值 -1
     */
    public static int getInt(String key) {
        return getInt(key, -1);
    }

    /**
     * SP中读取int
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static int getInt(String key, int defaultValue) {
        if (null != sp) {
            return sp.getInt(key, defaultValue);
        } else {
            throw new UnsupportedOperationException("SharePreference不能为空！请初始化该类！");
        }
    }

    /**
     * SP中读取long
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public static long getLong(String key) {
        return getLong(key, -1L);
    }

    /**
     * SP中读取long
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static long getLong(String key, long defaultValue) {
        if (null != sp) {
            return sp.getLong(key, defaultValue);
        } else {
            throw new UnsupportedOperationException("SharePreference不能为空！请初始化该类！");
        }
    }


    /**
     * SP中读取float
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值-1
     */
    public static float getFloat(String key) {
        return getFloat(key, -1f);
    }

    /**
     * SP中读取float
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static float getFloat(String key, float defaultValue) {
        if (null != sp) {
            return sp.getFloat(key, defaultValue);
        } else {
            throw new UnsupportedOperationException("SharePreference不能为空！请初始化该类！");
        }
    }

    /**
     * SP中读取boolean
     *
     * @param key 键
     * @return 存在返回对应值，不存在返回默认值{@code false}
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * SP中读取boolean
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 存在返回对应值，不存在返回默认值{@code defaultValue}
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        if (null != sp) {
            return sp.getBoolean(key, defaultValue);
        } else {
            throw new UnsupportedOperationException("SharePreference不能为空！请初始化该类！");
        }

    }

    /**
     * SP中读取字符串集合
     * @param key 键
     * @param defaultValue 默认值
     * @return
     */
    public static Set<String> getStringSet(String key , Set<String> defaultValue ){
        if (null != sp) {
            return sp.getStringSet(key,defaultValue);
        } else {
            throw new UnsupportedOperationException("SharePreference不能为空！请初始化该类！");
        }
    }

    /**
     * 从SP中移除该key
     *
     * @param key 键
     */
    public static void remove(String key) {
        if (null != editor) {
            editor.remove(key).apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.remove(key).apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }
    }

    /**
     * 判断SP中是否存在该key
     *
     * @param key 键
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public static boolean contains(String key) {
        return sp.contains(key);
    }

    /**
     * 清除SP中所有数据
     */
    public static void clear() {
        if (null != editor) {
            editor.clear().apply();
        } else {
            if (null != sp) {
                editor = sp.edit();
                editor.clear().apply();
            } else {
                if (null != mContext) {
                    throw new UnsupportedOperationException("上下文不能为空！请初始化该类！");
                }
            }
        }
    }
}
