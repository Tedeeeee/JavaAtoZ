package src.sec05.chap05;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 *  - 중간 연산자 -
 *  1. peek : 스트림에 영향을 끼치지 않는 Consumer 의 역할
 *  2. filter : 주어진 Predicate 에 충족하는 요소만 남긴다
 *  3. distinct : 중복되지 않는 요소들의 스트림을 반환
 *  4. map : 주어진 Function에 따른 요소를 변경
 *  5. sorted : 요소를 정렬
 *  6. limit : 주어진 수 만큼의 요소들을 스트림으로 반환
 *  7. skip : 앞에서 주어진 갯수만큼의 요소를 제거
 *  8. takeWhile/dropWhile : 주어진 Predicate를 충족하는 동안 취하거나 건너뛴다
 *
 *  - 최종 연산자 -
 *  1. forEach : 각 요소들에 주어진 Consumer 를 실행
 *  2. count : 요소들의 갯수를 반환
 *  3. min / max : 주어진 Comparator에 따른 최소, 최대 값을 반환
 *  4. reduce : 주어진 초기값과 BinaryOperator로 값들을 하나의 값으로 반환
 */

public class Ex01 {
    public static void main(String[] args) {
        IntStream
                .range(1, 100)
                .filter(i -> i % 2 == 0)
                .skip(10)
                .limit(10)
                .map(i -> i * 10)
                .forEach(System.out::println);

        System.out.println("\n- - - - - -\n");

        String str1 = "Hello World! Welcome to the world of Java~";

        str1.chars().forEach(System.out::println);

        System.out.println("\n- - - - - -");

        char str1MaxChar = (char) str1.chars()
                .max() // OptionalInt 반환
                //.min()
                .getAsInt();

        // 사용되는 모든 알파벳 문자들을 정렬해서 프린트
        str1.chars()
                .sorted()
                .distinct()
                .filter(i -> (i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z'))
                .forEach(i -> System.out.print((char) i));

        System.out.println("\n- - - - - -");

        // 대소문자 구분 없이 중복 제거를 하고 정렬하여 쉼표로 구분한다.
        String fromStr1 = str1.chars().boxed()
                // boxed를 사용해서 Stream<Integer>로 변환
                // 요소를 다른 타입으로 바꾸려면 Stream<T>를 사용해야 한다.
                .map(i -> String.valueOf((char) i.intValue()))
                .map(String::toUpperCase)
                .filter(s -> Character.isLetter(s.charAt(0)))
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("\n- - - - - -");

        // peek 로 중간과정을 체크하기
        // - 스트림이나 요소를 변경하지 않고 특정 작업을 수행한다. -> 디버깅에 유용하다
        String oddSquaresR = IntStream.range(0, 10).boxed()
                .peek(i -> System.out.println("초기값 : " + i))
                .filter(i -> i % 2 == 1)
                .peek(i -> System.out.println("홀수만 : " + i))
                .map(i -> i * i)
                .peek(i -> System.out.println("제곱 : " + i))
                .sorted((i1, i2) -> i1 < i2 ? 1 : -1)
                .peek(i -> System.out.println("역순 : " + i))
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("\n- - - - - -");

        Integer[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // allMatch / anyMatch : 모든 요소가 / 어느 한 요소라도
        // - 주어진 Predicate에 부합하는가 여부 반환
        boolean intsMatch = Arrays.stream(ints)
                //.allMatch(i -> i > 0);
                //.allMatch(i -> i % 2 == 0);
                //.anyMatch(i -> i < 0);
                .anyMatch(i -> i % 2 == 0);

        System.out.println("\n- - - - - -");

        // 주어진 Predicate를 충족시킬떄까지 takeWhile(취함) / dropWhile(건너뛴다).
        // count : 중간 과정을 거친 요소들의 갯수를 반환한다
        long afterWhileOp = Arrays.stream(ints)
                //.takeWhile(i -> i < 4)
                .dropWhile(i -> i < 4)
                .peek(System.out::println)
                .count();

        // sum : IntStream, LongStream, DoubleStream 요소의 총합 반환
        int intsSum = IntStream.range(0, 100 + 1)
                //.filter(i -> i % 2 == 1)
                //.filter(i -> i % 2 == 0)
                //.filter(i -> i % 3 == 0)
                .sum();

        System.out.println("\n- - - - - -");

        double doubleSum = DoubleStream.iterate(3.14, i -> i * 2)
                .limit(10)
                .peek(System.out::println)
                .sum();
    }
}
