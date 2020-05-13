package juc;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.TimeUnit;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/11 18:43
 * @Version 1.0
 */
class Phone{
    public synchronized void sendEmail() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("=======sendEmail");
    }
    public static synchronized void sendSMS(){
        System.out.println("=======sendSMS");
    }
    public void sayHello(){
        System.out.println("=======sayHello");
    }
}
public class Locks8Demo03 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1=new Phone();
        Phone phone2=new Phone();
        new  Thread(() ->{
            try {
                phone1.sendEmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        Thread.sleep(3000);
        new  Thread(() ->{
//            phone1.sayHello();
//            phone2.sendSMS();

            Phone.sendSMS();
        },"B").start();
    }
}