package juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author Xia ShengSheng
 * @Date 2020/5/5 15:21
 * @Version 1.0
 */
//使用ArrayList会出现并发修改异常：java.util.ConcurrentModificationException
//解决方案：Vector()
//          Collections.synchronizedList(new ArrayList<>())
//          new CopyOnWriteArrayList<>()
public class NotSofeDemo02 {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
