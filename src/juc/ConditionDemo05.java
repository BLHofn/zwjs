package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/13 21:55
 * @Version 1.0
 */
//多线程按顺序调用实现A->B->C
//    精准通知
class ShareData{
    Lock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();
    private static int number=1;
    public void p5(){
        lock.lock();
        try {
            while(number!=1){
                c1.await();
            }
            for (int i=1;i<=5;i++)
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            number=2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void p10(){
        lock.lock();
        try {
            while(number!=2){
                c2.await();
            }
            for (int i=1;i<=10;i++)
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            number=3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void p15(){
        lock.lock();
        try {
            while(number!=3){
                c3.await();
            }
            for (int i=1;i<=15;i++)
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            number=1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ConditionDemo05 {
    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        new Thread(() ->{
            for (int i=0;i<10;i++){
                shareData.p5();
            }
        },"A").start();
        new Thread(() ->{
            for (int i=0;i<10;i++){
                shareData.p10();
            }
        },"B").start();
        new Thread(() ->{
            for (int i=0;i<10;i++){
                shareData.p15();
            }
        },"C").start();
    }
}
