package juc;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/5 13:43
 * @Version 1.0
 */

@FunctionalInterface
//函数式接口：里面只能有一个方法的定义，多个方法的实现（包括静态方法和default修饰的方法）
interface Foo1 {
//    public void m1();
    public int m2(int x, int y);

    default void m3() {
        System.out.println("m3");
    }

    default void m4() {
        System.out.println("m4");
    }

    public static void m5() {
        System.out.println("m5");
    }

    public static void m6() {
        System.out.println("m6");
    }

}
//普通接口：可以定义属性,可以定义多个抽象方法，
//         可以有多个default修饰的方法的实现，以及定义多个静态方法的实现
interface Foo2{
    int k = 0;
    public void m1();
    public int m2(int x, int y);
    default void m3(){
        System.out.println("m3");
    }
    public static void m4(){
        System.out.println("m4");
    }
}
public class 函数式接口和接口 implements Foo2 {
    public static void main(String[] args) {
//        Foo1 foo1 = (int x,int y) ->{
//            System.out.println("sda");
//            return x+y;
//        };
//        System.out.println(foo1.m2(1, 3));
        System.out.println(k);
        函数式接口和接口 jj=new 函数式接口和接口();
        jj.m3();
        Foo2.m4();
    }

    @Override
    public void m1() {

    }

    @Override
    public int m2(int x, int y) {
        return 0;
    }

    @Override
    public void m3() {

        System.out.println("hahah");
    }
}
