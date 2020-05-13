package 设计模式.单例模式;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/4 20:53
 * @Version 1.0
 */
//是否 Lazy 初始化：是
//是否多线程安全：否
//实现难度：易
//描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
//这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
public class 懒汉式不安全 {
    private static 懒汉式不安全 instance;

    private 懒汉式不安全() {
    }

    public static 懒汉式不安全 getInstance() {
        if (instance == null) {
            instance = new 懒汉式不安全();
        }
        return instance;
    }

}
