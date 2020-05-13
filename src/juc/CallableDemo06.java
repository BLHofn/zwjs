package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/13 22:26
 * @Version 1.0
 */
class MyThread1 implements Runnable{

    @Override
    public void run() {
        System.out.println("runable run");
    }
}
class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("callable call");
        return "XSS";
    }
}
public class CallableDemo06 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask=new FutureTask(new MyThread2());
        new Thread(futureTask,"A").start();
        Object result = futureTask.get();
        System.out.println(result);
    }
}
