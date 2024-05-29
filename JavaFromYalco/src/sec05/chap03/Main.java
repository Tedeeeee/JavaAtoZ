package src.sec05.chap03;

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
    }
}
