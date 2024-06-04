package src.sec07.chap01;

import java.util.stream.IntStream;

public class WrongSleep {
    public static void main(String[] args) {
        Thread sleeper = new Thread(
                () -> IntStream.range(0, 5)
                        .forEach(i -> {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("쿨");
                        })
        );
        sleeper.start();

        try {
            // sleeper 쓰레드를 재우려고 하지만 sleep은 정적 메소드이다
            // 현재 진행하는 쓰레드가 잠든다.
            sleeper.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("잘잤다!");
    }
}
