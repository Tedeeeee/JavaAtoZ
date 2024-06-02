package src.sec06.chap02;

import src.sec03.chap04.*;

import java.util.stream.*;

/**
 *  finally 문
 *  - 예외 발생 여부에 상관없이 반드시 실행할 코드
 *   : 데이터 베이스 연결을 열어 작업한 뒤 닫아줄 때 등에 사용한다
 */

public class Ex02 {

    public static void withFinally1 (boolean makeException) {
        try {
            if (makeException) System.out.println("".charAt(0));
            System.out.println("예외 없는 정상 실행");
        } catch (Exception e) {
            System.out.println("예외 발생");
        } finally {
            System.out.println("무조건 실행된다.");
        }

        // try 문 밖에 실행하면 되는거 아냐?
        System.out.println("try 문 밖에서 그냥 실행하면 되는 거 아닌가?");
    }

    public static char withFinally2(int index) {
        String str = "Hello";

        try {
            char result = str.charAt(index);
            System.out.println("예외 없이 정상실행된다.");
            return result;
        } catch (Exception e) {
            System.out.println("예외 발생");
            return '!';
        } finally {
            // return이 발생해도 실행된다.
            System.out.println("무조건 실행된다");
        }

        // return으로 인해 메소드가 완전히 종료되어 문법이 실행이 안됨
        // System.out.println("실행이 안됨");
    }

    //  💡 다중 catch 문 이후에도 사용됨
    public static void withFinally3 (int i) {
        try {
            switch (i) {
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        } finally {
            System.out.println("🏁 무조건 실행");
        }
    }

    public static void main(String[] args) {
        withFinally1(false);
        System.out.println("- - - - -");
        withFinally1(true);

        System.out.println("\n- - - - -\n");

        char char1 = withFinally2(3);
        char char2 = withFinally2(6);

        System.out.println("\n- - - - -\n");

        // 각각의 실행 결과에 모든 finally가 실행
        IntStream.rangeClosed(0, 4)
                .forEach(Ex02::withFinally3);
    }
}
