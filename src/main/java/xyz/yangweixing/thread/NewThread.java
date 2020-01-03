package xyz.yangweixing.thread;

/**
 * <p>
 * Description: 启动线程的两种方式
 * </p>
 *
 * @author qiwen
 * @version 1.0.0
 * @date 2020/1/3 10:32
 * @see xyz.yangweixing.thread
 */
public class NewThread {

    /** 扩展 Thread 类 */
    private static class UseThread extends Thread {
        @Override
        public void run() {
            // do my work;
            System.out.println("I am extend Thread");
        }
    }

    /** 实现 Runnable 接口 */
    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            // do my work;
            System.out.println("I am implements Runnable");
        }
    }

    public static void main(String[] args) {
        UseThread useThread = new UseThread();
        useThread.start();

        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();
    }

}
