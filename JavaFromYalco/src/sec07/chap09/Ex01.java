package src.sec07.chap09;

import java.util.*;

/**
 *  Thread - Safe 한 클래스
 *  Concurrent 컬렉션
 */

public class Ex01 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        Runnable toHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                hashMap.put("key" + i, i);
            }
        };

        Thread t1 = new Thread(toHashMap);
        Thread t2 = new Thread(toHashMap);
        Thread t3 = new Thread(toHashMap);

        t1.start(); t2.start(); t3.start();

        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {}

        // 한개의 HashMap을 다양한 쓰레드에서 요소를 추가하기 때문에 문제가 발생한다.
        // size가 10000개가 있어야 하지만 size를 보면 10000이 아니라는 것을 알 수 있다.
        // 이를 Thread-safe하지 않는다는 얘기를 한다
    }
}
