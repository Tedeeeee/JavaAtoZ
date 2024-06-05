package src.sec07.chap06.ex02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  비동기적 연산의 결과
 *   - ExecutorService 인스턴스의 submit 메소드가 반환된다
 *    -> 인자로 Callable을 받았다
 *   - "~해서 얻어올 것"이란 의미
 *    -> 비동기 작업 이후에 get메소드로 최종 값을 받아온다
 */
public class FutureExp {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        // submit 메소드 : Callable을 받아서 Future를 반환한다
        // - 'String을 받아올 임무를 가진 것'이란 의미
        // - execute 메소드(Runnable을 받음)와 비교
        Future<String> callAnswer = es.submit(() -> {
            Thread.sleep(2000);
            return "여보세요";
        });

        // get메소드를 호출하기 전까지는 막히지 않고 동시에 진행한다
        // - Future의 Callable은 다른 쓰레드에서 진행된다.

        // isDone 메소드 : 퓨쳐의 태스크가 종료되었느지 여부를 확인한다
        while (!callAnswer.isDone()) {
            System.out.println("📞 따르릉...");
            try { Thread.sleep(400);
            } catch (InterruptedException e) {}
        }

        String result = null;

        // get메소드 : 해당 Future 쓰레드의 작업이 끝난 뒤 결과를 받아온다
        // - 이를 완료하기까지 그 뒤의 작업들이 모두 막힌다
        // - 대안을 위해 CompletableFuture가 있다
        try {
            result = callAnswer.get();
        } catch (InterruptedException | ExecutionException e) {}

        System.out.println("✅ 통화 시작 - " + result);
        System.out.println("- - - 작업 종료 - - -");

        es.shutdown();
    }
}
