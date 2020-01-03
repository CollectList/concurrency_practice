package xyz.yangweixing.tools;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * Description: 线程休眠辅助工具类
 * </p>
 *
 * @author qiwen
 * @version 1.0.0
 * @date 2020/1/3 14:51
 * @see xyz.yangweixing.tools
 */
public class SleepTools {

    /**
     * 按秒休眠
     *
     * @param seconds 秒数
     */
    public static final void second(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 按毫秒数休眠
     *
     * @param seconds 毫秒数
     */
    public static final void ms(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
