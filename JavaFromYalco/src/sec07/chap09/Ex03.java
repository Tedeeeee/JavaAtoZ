package src.sec07.chap09;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  기타 동시성 관련 컬렉션
 *  - ConcurrentLinkedQueue : 내부 구획을 사용한 큐
 *  - CopyOnWriteArrayList, CopyOnWriteArraySet
 *   : 요소 추가 / 제거 시마다 내부배열을 복사한다
 *    -> 수정 작업이 이뤄지는 동안에도 읽기 문제가 발생하지 않는다
 *  - ConcurrentSkipListSet, ConcurrentSkipListMap
 *   : 내부 구획을 사용해서 쓰레드의 안정성을 확보한다
 *   : Skip List란 구조를 사용해서 읽고 쓰기를 빠르게 한다
 */
public class Ex03 {
    // Atomic 클래스
    // 특정 변수에 대해 쓰레드로부터의 안전 제공
    // -> 한번에 하나의 쓰레드만 접근이 가능하다
    static int count = 0;
    static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable incCount = () -> {
            for (int i = 0; i < 10000; i++) {
                count++;
                atomicCount.getAndIncrement();
            }
        };

        Thread t1 = new Thread(incCount);
        Thread t2 = new Thread(incCount);
        Thread t3 = new Thread(incCount);

        t1.start(); t2.start(); t3.start();

        try {
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {}

        int result = count;
        int atomicResult = atomicCount.get();
    }
}
