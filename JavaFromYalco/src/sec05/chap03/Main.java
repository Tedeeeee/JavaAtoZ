package src.sec05.chap03;

import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 *  Method reference
 *  - 람다식이 어떤 메소드 하나만 호출할 때 코드를 간편화한다
 *  -- 즉, 해당 람다식과 메소드의 의미가 사실상 같을때
 *  - 해당 메소드가 인터페이스와 인자, 리턴 값 구성이 동일할때
 *
 *  클래스 메소드 호출
 *  {클래스명}::{클래스 메소드명}
 *
 *  인스턴스 메소드 호출
 *  {클래스명}::{인스턴스메소드명}
 *  {인스턴스}::{인스턴스메소드명}
 *
 *  클래스 생성자 호출
 *  {클래스}::new
 */
public class Main {
    public static void main(String[] args) {
        Function<Integer, String> intToStrLD = (i) -> String.valueOf(i);
        // 위에 과정이 굉장히 단촐해진다.
        Function<Integer, String> intToStrMR = String::valueOf;

        String intToStr = intToStrMR.apply(123);

        // 인자로 받은 인스턴스의 메소드를 실행한다.
        UnaryOperator<String> toLCaseLD = s -> s.toLowerCase();
        UnaryOperator<String> toLCaseMR = String::toLowerCase;

        String toLCase = toLCaseMR.apply("HELLO");

        System.out.println("\n- - - - - -");

        // 한개의 인자만 받는 것은 new 라는 연산자를 메소드 참조로 만들수 있다.
        Function<String, Button> strToButtonLD = s -> new Button(s);
        Function<String, Button> strToButtonMR = Button::new;

        Button button1 = strToButtonMR.apply("Dog");

        // 두개의 인자를 받는 생성자도 존재하기 때문에 new 연산자를 통해 생성 가능
        BiFunction<String, String, Button> twoStrToButtonLD = (s1, s2) -> new Button(s1, s2);
        BiFunction<String, String, Button> twoStrToButtonMR = Button::new;

        Button button2 = twoStrToButtonMR.apply("고양이", "야옹");
        // Button에서 제작된 run을 실행
        button2.onClick();

        System.out.println("- - - - - -");

        // 반환값이 존재하지 않는 print이기 때문에 Runnable로 구현 가능
        Runnable catCryLD = () -> button2.onClick();
        // button1 에 존재하는 onClick를 메소드 참조로 구현
        Runnable catCryMR = button2::onClick;

        catCryMR.run();

        //  💡 임의의 인스턴스의 메소드 참조
        // compareTo는 1개의 인자만을 받지만 두 개의 인자가 가능한 이유는
        // 첫번째 인자가 임의의 인스턴스로 만들어져서 비교가 되기 때문이다.
        TreeSet<String> treeSetLD = new TreeSet<>((s1, s2) -> s1.compareTo(s2));
        TreeSet<String> treeSetMD = new TreeSet<>(String::compareTo);
    }
}
