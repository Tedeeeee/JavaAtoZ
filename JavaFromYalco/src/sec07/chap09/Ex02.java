package src.sec07.chap09;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Ex02 {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        // ConcurrentHashMap
        // 동기화 된 해시맵이다
        // 맵을 구획으로 분할하여 각 구획에 대해 동기화를 적용한다
        // 각 쓰레드가 서로 다른 구획에 접근한다.
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Runnable toHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                hashMap.put("key" + i, i);
            }
        };

        Runnable toConcurrHashMap = () -> {
            for (int i = 0; i < 10000; i++) {
                concurrentHashMap.put("key" + i, i);
            }
        };

        System.out.println("일반 해시맵 결과");
        measureTime("일반 해시맵", () -> {
            Thread t1 = new Thread(toHashMap);
            Thread t2 = new Thread(toHashMap);
            Thread t3 = new Thread(toHashMap);

            t1.start(); t2.start(); t3.start();
            try {
                t1.join(); t2.join(); t3.join();
            } catch (InterruptedException e) {}

            System.out.printf(
                    "일반 해시맵 사이즈 : %d%n",
                    hashMap.size()
            );
        });
        System.out.println("concurrent해시맵 결과");
        measureTime("Concurrent 해시맵", () -> {
            Thread t1 = new Thread(toConcurrHashMap);
            Thread t2 = new Thread(toConcurrHashMap);
            Thread t3 = new Thread(toConcurrHashMap);

            t1.start(); t2.start(); t3.start();
            try {
                t1.join(); t2.join(); t3.join();
            } catch (InterruptedException e) {}

            System.out.printf(
                    "Concurrent 해시맵 사이즈 : %d%n",
                    concurrentHashMap.size()
            );
        });

    }

    public static void measureTime(String taskName, Runnable runnable) {
        long startTime = System.nanoTime();

        runnable.run();

        long endTime = System.nanoTime();

        System.out.printf(
                "⌛️ %s 소요시간: %,d 나노초%n",
                taskName,
                endTime - startTime
        );
    }
}
