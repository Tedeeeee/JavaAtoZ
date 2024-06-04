package src.sec06.chap06;

import src.sec03.chap04.*;

import java.util.*;
import java.util.stream.IntStream;

/**
 *  Optional
 *  - Optional<T> : null일 수도 있는 T타입의 값
 *  - null일 수 있는 값을 보다 안전하고 간편하게 사용하기 위해서 이다.
 */
public class Ex02 {
    public static Optional<String> getCatOpt() {
        return Optional.ofNullable(
                new Random().nextBoolean() ? "Cat" : null
        );
    }

    public static Optional<Unit> randomUnitOpt() {
        switch (new Random().nextInt(0, 3)) {
            //  💡 각 return 문을 가지므로 break 필요 없음
            case 0: return Optional.of(new Knight(Side.BLUE));
            case 1: return Optional.of(new MagicKnight(Side.BLUE));

            default: return Optional.empty();
        }
        // Optional을 반환하는 메소드는 null을 반환하도록 하지 말아야한다.
        // - 대신 빈 Optional을 반환한다.
        // - NPE를 방지하기 위한 메소드이기 때문이다.
    }

    public static void main(String[] args) {
        // Optional 만들기
        // of : 담으려는 것이 확실히 있을 때
        Optional<String> catOpt = Optional.of("Cat");
        // of로 null을 담으면 NPE
        // catOpt = Optional.of(null);

        // ofNullable은 null을 담기 가능
        Optional<String> dogOpt = Optional.ofNullable("Dog");
        Optional<String> cowOpt = Optional.ofNullable(null);

        // 명시적으로 null을 담으려면 empty 메소드
        Optional<String> henOpt = Optional.empty();

        // null이여도 NPE가 발생하지 않도록 만들수 있다
        catOpt = getCatOpt();

        List<Optional<Unit>> randomUnitOpts = new ArrayList<>();
        IntStream.range(0, 20)
                .forEach(i -> randomUnitOpts.add(randomUnitOpt()));

        randomUnitOpts.stream()
                .forEach(opt -> System.out.println(
                        opt.isPresent() // 있다면 true
                        // opt.isEmpty() // 없다면 true

                        // opt.get() // 있다면 반환, 없다면 NPE

                        // 없을 시 다른 것을 반환한다. (기본값으로 사용한다)
                        // opt.orElse(new Swordman(Side.RED))
                ));

        System.out.println("\n- - - - -\n");

        randomUnitOpts.stream()
                .forEach(opt -> {
                    // 있을 때 실행할 Consumer
                    // opt.ifPresent(unit -> System.out.println(unit));

                    // 있다면 실행할 Consumer, 없다면 실행할 Runner(없기때문에)
                    opt.ifPresentOrElse(
                            unit -> System.out.println(unit),
                            () -> System.out.println("(유닛 없음)")
                    );
                });

        System.out.println("\n- - - - -\n");

        List<Optional<Integer>> optInts = new ArrayList<>();
        IntStream.range(0 , 20)
                .forEach(i -> {
                    optInts.add(Optional.ofNullable(
                            new Random().nextBoolean() ? i : null
                    ));
                });

        // Optional의 filter와 map 메소드
        // Optional의 filter : 걸러진 값은 null로 인식
        // Stream의 filter : 걸러낸 값들만 사용
        optInts.stream()
                .forEach(opt -> {
                    System.out.println(
                            opt
                                    .filter(i -> i % 2 == 1)
                                    .map(i -> "%d 출력".formatted(i))
                                    // filter에 의해 짝수는 모두 null로 본다
                                    // 때문에 SKIP으로 변경된 것을 확인
                                    .orElse("(SKIP)")
                    );
                });
    }


}
