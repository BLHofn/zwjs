package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/4 20:41
 * @Version 1.0
 */
//在高内聚低耦合的前提下 线程操作资源类
class Ticket {
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第:" + (number--) + "张  还剩下:" + number + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SaleTickeDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        lamda表达式：new Thread(()->{ 逻辑代码 },"线程名称").start();
        new Thread(()->{for(int i=0;i<40;i++){ticket.sale();}},"A1").start();
        new Thread(()->{for(int i=0;i<40;i++){ticket.sale();}},"A2").start();
        new Thread(()->{for(int i=0;i<40;i++){ticket.sale();}},"A3").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "A1").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "A2").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "A3").start();
    }
}
