package 设计模式.单例模式;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/4 20:54
 * @Version 1.0
 */
//JDK 版本：JDK1.5 起
//是否 Lazy 初始化：是
//是否多线程安全：是
//实现难度：较复杂
//描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
//getInstance() 的性能对应用程序很关键。
public class 双重校验锁 {
    private volatile static 双重校验锁 singleton;
    private 双重校验锁 (){}
    public static 双重校验锁 getSingleton() {
        if (singleton == null) {
            synchronized (双重校验锁.class) {
                if (singleton == null) {
                    singleton = new 双重校验锁();
                }
            }
        }
        return singleton;
    }
}
