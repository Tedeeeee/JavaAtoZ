package src.sec07.chap06.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class TryFuture {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);

        List<Future<Integer>> futList = new ArrayList<>();

        IntStream.range(0,10)
                .forEach(i -> {
                    futList.add(
                            es.submit(new RollDiceCall())
                    );
                });

        es.shutdown();

        ArrayList<Integer> intList = new ArrayList<>();
        for (Future<Integer> future : futList) {
            try {
                intList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {}
        }

        // 여기는 main 쓰레드의 영역이지만 위의 코드인 future.get이 진행되지 않으면
        // 여기선 진행이 되지 않는 것을 볼 수 있다.
        System.out.println(String.join(
                ",",
                intList.stream().map(String::valueOf).toArray(String[]::new)
        ));
    }
}
