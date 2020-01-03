package xyz.yangweixing.thread;

/**
 * <p>
 * Description: StartAndRun在执行上的区别
 * </p>
 *
 * @author qiwen
 * @version 1.0.0
 * @date 2020/1/3 11:00
 * @see xyz.yangweixing.thread
 */
public class StartAndRun {

    public static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 90;
            while (i > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am " + Thread.currentThread().getName() + " and now the i=" + i--);
            }
            super.run();
        }
    }

    /**
     * Thread类是Java里对线程概念的抽象，
     * 可以这样理解：我们通过new Thread()其实只是 new 出一个 Thread 的实例，
     * 还没有操作系统中真正的线程挂起钩来。只有执行了 start()方法后， 才实现了真正意义上的启动线程。
     *
     * star()方法让一个线程进入就绪队列等待分配cpu，分到cpu后才调用实现的run()方法，
     * start()方法不能重复调用，如果重复调用会抛出异常。
     *
     * run()方法是业务逻辑实现的地方，本质上和任意一个类的任意一个成员方法并没有任何区别，
     * 可以重复执行， 也可以被单独调用。
     * @param args
     */
    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("threadRun");
        threadRun.start();
    }
}
