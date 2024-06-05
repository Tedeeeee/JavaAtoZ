package src.sec07.chap08;

import java.util.*;
import java.util.stream.Stream;

/**
 *  병렬 스트림
 *  - 자바 스트림의 일부 메소드는 병렬로 처리가 가능하다.
 *   -- filter, map, reduce
 *   -- 쓰레드 여럿에 분할하여 할 수 있는 작업들이다
 *
 *  - 대부분의 경우 성능의 향상을 돕는다
 *   -- 여러 쓰레드에서 병렬로 처리되기 떄문이다
 *   -- 작업에 따라서는 오히려 느려질 가능성도 존재한다
 *   1. 데이터가 너무 작을 경우 -> 쓰레드 생성 시간이 더 크다
 *   2. 순차적으로 처리되어야 하는 작업
 */
public class Ex01 {

    public static void main(String[] args) {
        Stream<Character> stream1 = Stream.of('A', 'B', 'C');

        // isParallel : 스팀이 병렬인지 여부를 판단
        boolean bool1 = stream1.isParallel();

        // parallel : 직렬 스트림을 병렬로 변경
        stream1.parallel();
        boolean bool2 = stream1.isParallel();

        // sequential : 병렬 스트림을 직렬로 바꾼다
        stream1.sequential();
        boolean bool3 = stream1.isParallel();

        // 처음부터 병렬 스트림으로 생성하는 방법
        // Arrays와 Collection의 parallelStream을 사용한다
        Stream<Integer> stream2 = Arrays.asList(1, 2, 3, 4, 5)
                .parallelStream();

        List<Double> dblList = new ArrayList<>(
                Arrays.asList(1.23, 2.34, 3.45)
        );
        Stream<Double> stream3 = dblList.parallelStream();
    }
}
