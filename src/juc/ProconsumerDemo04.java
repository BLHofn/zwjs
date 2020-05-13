package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/13 21:00
 * @Version 1.0
 */
class AirCondition {
    public static int number = 0;

    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
        public  void incre() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0)
                condition.await();
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void decre() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0)
                condition.await();
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
//    public synchronized void incre() throws InterruptedException {
//        while (number != 0)
//            this.wait();
//        number++;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        this.notifyAll();
//    }
//
//    public synchronized void decre() throws InterruptedException {
//        while (number == 0)
//            this.wait();
//        number--;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        this.notifyAll();
//    }
}

public class ProconsumerDemo04 {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decre();
                    ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.incre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decre();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}
