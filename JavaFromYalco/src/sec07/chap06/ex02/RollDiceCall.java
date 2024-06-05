package src.sec07.chap06.ex02;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 *  concurrent 패키지의 클래스
 *  Runnable처럼 다른 쓰레드에서의 작업에 사용이 가능하다
 */
public class RollDiceCall implements Callable<Integer> {

    // Callable 인터페이스
    // - 함수형 인터페이스 (클래스 확인할 것)
    // Runnable과의 차이 :
    // - 값 반환 (Supplier 처럼)
    // - Exception을 던진다
    @Override
    public Integer call() throws Exception {
        // 이미 Exception이 던져져서 InturruptedException이 필요가 없다
        Thread.sleep(1000);

        int result = new Random().nextInt(0, 6) + 1;
        System.out.println(result);

        return result;
    }
}
