package src.sec05.chap04;

import src.sec03.chap04.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

/**
 *  Stream 형태로 만드는 방법은 다양하다
 *
 *  밑은 각각의 원시값, 참조값, 클래스형, Builder 패턴까지 모두 만드는 방법을 보여준다.
 *  각각의 toArray 메소드를 생성하는 이유는 만들어진 물결을 보여주기 위함이다.
 */

public class Ex02 {
    public static void main(String[] args) {
        Integer[] integerAry = {1, 2, 3, 4, 5};
        Stream<Integer> fromArray = Arrays.stream(integerAry);
        // 흘러가는 물을 toArray를 통해 통에 담아서 확인시켜준다
        Object[] fromArray_Arr = fromArray.toArray();

        // 런타임 에러가 발생한다
        // - 스트림은 한 번 사용하면 끝이다.
        // Object[] ifReuse = fromArray.toArray();

        // 원시값의 배열로부터는 스트림의 클래스가 달라진다.
        int[] intAry = {1, 2, 3, 4, 5};
        IntStream fromIntAry = Arrays.stream(intAry);
        int[] fromIntAry_Arr = fromIntAry.toArray();

        double[] dblAry = {1.1, 2.2, 3.3};
        DoubleStream fromDblAry = Arrays.stream(dblAry);
        double[] fromDblAry_Arr = fromDblAry.toArray();

        // 값들로 직접 생성한다
        IntStream withInts = IntStream.of(1, 2, 3, 4, 5);
        Stream<Integer> withIntegers = Stream.of(1, 2, 3, 4, 5);
        Stream<Unit> withUnits = Stream.of(
                new Swordman(Side.BLUE),
                new Knight(Side.BLUE),
                new MagicKnight(Side.BLUE)
        );
        Object[] withUnits_Arr = withUnits.toArray();

        // 컬렉션으로부터 생성한다
        List<Integer> intAryList = new ArrayList<>(Arrays.asList(integerAry));
        Stream fromColl1 = intAryList.stream();
        Object[] fromColl1_Arr = fromColl1.toArray();

        // Map의 경우 Entry의 스트림으로 생성한다.
        Map<String, Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("English", 'B');
        subjectGradeHM.put("Math", 'C');
        subjectGradeHM.put("Programming", 'A');
        Object[] fromHashMap_Arr = subjectGradeHM.entrySet().stream().toArray();

        // 빌더로써 생성할 수도 있다
        Stream.Builder<Character> builder = Stream.builder();
        builder.accept('스');
        builder.accept('트');
        builder.accept('림');
        builder.accept('빌');
        builder.accept('더');
        Stream<Character> withBuilder = builder.build();
        Object[] withBuilder_Arr = withBuilder.toArray();

        // Concat으로 반환값이 같은 두개의 인스턴스를 합치는 것도 가능하다
        Stream<Integer> toConcat1 = Stream.of(11, 22, 33);
        Stream<Integer> toConcat2 = Stream.of(44, 55, 66);
        Stream<Integer> withConcatMethod = Stream.concat(toConcat1, toConcat2);
        Object[] withConcatMethod_Arr = withConcatMethod.toArray();

        // Iterator로써 생성이 가능하다
        // - 인자 : 초기값, 다음 값을 구하는 람다 함수
        // - limit으로 횟수를 지정해야 한다.
        Stream<Integer> withIter1 = Stream
                .iterate(0, i -> i + 2)
                .limit(10);
        Object[] withIter1_Arr = withIter1.toArray();

        Stream<String> withIter2 = Stream
                .iterate("홀", s -> s + (s.endsWith("홀") ? "짝" : "홀"))
                .limit(8);
        Object[] withIter2_Arr = withIter2.toArray();

        // 원시자료형 스트림의 기능들로 생성이 가능
        IntStream fromRange1 = IntStream.range(10, 20); // 20은 미포함시킨다
        IntStream fromRange2 = IntStream.rangeClosed(10, 20); // 20을 포함시킨다

        // 원시 자료형을 참조 자료형으로 만들어 주기 위해 boxed() 메소드를 사용한다.
        // 이때 IntPipeLine이 유지되는 이유는
        // Stream<Integer> 객체는 내부적으로 원시 int 값들을 처리하는 IntPipeline을 기반으로 한다
        Stream<Integer> fromRangeBox = fromRange1.boxed();
        Object[] fromRangeBox_Arr = fromRangeBox.toArray();

        // Random 클래스의 스트림 생성 메소드들
        // 각 random의 원시값 메소드(갯수, 시작, 끝)
        IntStream randomInts = new Random().ints(5, 0, 100);
        int[] randomInts_Arr = randomInts.toArray();

        DoubleStream randomDbls = new Random().doubles(5, 2, 3);
        double[] randomDbls_Arr = randomDbls.toArray();

        // 문자열을 각 문자에 해당하는 정수의 스트림으로 변경
        IntStream fromString = "Hello World".chars();
        int[] fromString_Arr = fromString.toArray();

        // 파일의 내용으로 부터 생성한다
        Stream<String> fromFile;
        Path path = Paths.get("./src/sec05/chap04/turtle.txt");
        try {
            fromFile = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Object[] fromFile_Arr = fromFile.toArray();

        // 비어있는 스트림을 생성할 수 있다.
        // - 스트림을 받는 메소드 등에서 종종 사용한다.
        Stream<Double> emptyDblStream = Stream.empty();
    }
}
