package src.sec07.chap08;

import java.util.OptionalInt;
import java.util.stream.*;

public class Ex02 {

    public static void main(String[] args) {
        final int RANGE = 10_000_000;

        System.out.println("filter를 이용한 병렬 처리");
        measureTime("직렬 필터", () -> {
            IntStream filtered = IntStream.range(0 ,RANGE)
                    .filter(i -> i % 2 == 0);
        });

        measureTime("병렬 필터", () -> {
            IntStream filtered = IntStream.range(0, RANGE)
                    .parallel() // 각각의 스트림들을 병렬로 바꿔준다
                    .filter(i -> i % 2 == 0);
        });

        System.out.println("map을 이용한 병렬 처리");

        measureTime("직렬 매핑", () -> {
            Stream<String> mapped = IntStream.range(0, RANGE).boxed()
                    .map(String::valueOf);
        });

        measureTime("병렬 매핑", () -> {
            Stream<String> mapped = IntStream.range(0, RANGE).boxed()
                    .parallel()
                    .map(String::valueOf);
        });

        System.out.println("reduce를 이용한 병렬 처리");

        // reduce는 특성 상 누적 합, 곱 같이 앞에서부터 차근차근 작업을 진행한다
        // 때문에 병렬적인 처리와는 맞지 않는다.
        measureTime("직렬 접기", () -> {
            OptionalInt reduced = IntStream.range(0 , RANGE)
                    .reduce(Integer::sum);
        });

        measureTime("병렬 접기", () -> {
            OptionalInt reduced = IntStream.range(0 , RANGE)
                    .parallel()
                    .reduce(Integer::sum);
        });

        System.out.println("sum을 이용한 병렬 처리");

        // sum의 경우 그 안에 있는 건 모두 더하면 되기 때문에 오히려 병렬에 유리하다
        measureTime("직렬 합계", () -> {
            int sum = IntStream.range(0, RANGE)
                    .sum();
        });

        measureTime("병렬 합계", () -> {
            int sum = IntStream.range(0, RANGE)
                    .parallel()
                    .sum();
        });

        System.out.println("위에 사용한 처리 방법을 다양하게 섞어보기");

        final int TRI_RANGE = 10;

        measureTime("직렬 3종", () -> {
            OptionalInt tri = IntStream.range(0, TRI_RANGE)
                    .filter(i -> i % 2 == 0)
                    .map(i -> i + 1)
                    .reduce(Integer::sum);
        });

        measureTime("병렬 3종", () -> {
            OptionalInt tri = IntStream.range(0, TRI_RANGE)
                    .parallel()
                    .filter(i -> i % 2 == 0)
                    .map(i -> i + 1)
                    .reduce(Integer::sum);
        });

        // 작업에 따라 병렬과 직렬의 혼합이 유리할 수도 있다
        // - 밑의 작업인 경우 데이터 갯수가 작다
        // - 성능이 중요하다면 테스트를 해가면서 최적의 코드를 찾아야한다.
        measureTime("혼합 3종", () -> {
            OptionalInt tri = IntStream.range(0, TRI_RANGE)
                    .parallel()
                    .filter(i -> i % 2 == 0)
                    .map(i -> i + 1)
                    .sequential() // 직렬화로 변경
                    .reduce(Integer::sum);
        });


    }
    public static void measureTime(String taskName, Runnable runnable) {
        // System.nanoTime : 시간차를 구하는데 사용된다
        // - 정수 반환, 단 실제 현재 시간과는 상관이 없다
        //  - 초시계를 보고 현재 시각을 알 수 없듯이
        // - 두 시점의 값을 비교해서 속도를 측정하는 용도로 사용이 가능하다
        long startTime = System.nanoTime();

        runnable.run();

        long endTime = System.nanoTime();
        System.out.printf(
                "⌛️ %s 소요시간: %d 나노초%n",
                taskName,
                endTime - startTime
        );
    }
}
