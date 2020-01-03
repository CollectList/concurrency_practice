package xyz.yangweixing.syn;

/**
 * <p>
 * Description: synchronized关键字的使用方法
 * </p>
 *
 * @author qiwen
 * @version 1.0.0
 * @date 2020/1/3 11:51
 * @see xyz.yangweixing.syn
 */
public class SynchronizedExample {

    private long count = 0;

    /**作为一个锁*/
    private Object obj = new Object();

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    /**
     * 用在同步块上
     */
    public void incCount() {
        synchronized (obj) {
            count++;
        }
    }

    /**
     * 用在方法上
     */
    public synchronized void incCount2() {
        count++;
    }

    /**
     * 用在同步块上，但是锁的是当前类的对象实例
     */
    public void incCount3() {
        synchronized (this) {
            count++;
        }
    }

    private static class Count extends Thread {

        private SynchronizedExample simplOper;

        public Count(SynchronizedExample simplOper) {
            this.simplOper = simplOper;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                //count = count+10000
                simplOper.incCount();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample simplOper = new SynchronizedExample();
        //启动两个线程
        Count count1 = new Count(simplOper);
        Count count2 = new Count(simplOper);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(simplOper.count);
    }
}
