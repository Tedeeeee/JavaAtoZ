package src.sec06.chap02;

import src.sec03.chap04.*;

import java.util.stream.IntStream;

public class Ex01 {
    public static void tryThings1 (int i) {
        try {
            switch (i) {
                // 예외가 발생하면 바로 실행을 멈추고 catch 문으로 넘어간다.
                // - 아래 케이스들은 각각 예외가 발생하므로 break 넣지 않았다.
                case 1:
                    System.out.println((new int[1])[1]);
                case 2:
                    System.out.println("abc".charAt(3));
                case 3:
                    System.out.println((Knight) new Swordman(Side.RED));
                case 4:
                    System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);
        } catch (Exception e) {
            // 예외가 발생
            System.out.printf(
                    "%d: 🛑 [ %s ] %s%n", i, e.getClass(), e.getMessage()
            );
            e.printStackTrace();
        }
    }

    public static void tryThings2 (int i) {
        try {
            switch (i) {
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);

            //  💡 오류의 타입마다 다른 처리를 하고자 할 때
            //  ⭐️ 위에서 처리한 종류에 속하는 오류를 아래에 넣으면 컴파일 에러
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("%d : 🍡 배열의 크기를 벗어남%n", i);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.printf("%d : 🔤 문자열의 길이를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            //  💡 위에서 처리되지 못한 모든 타입의 오류
            //  ⭐️ 가장 아래에 있어야 함
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        }
    }

    public static void tryThings3 (int i) {
        try {
            switch (i) {
                case 1: System.out.println((new int[1])[1]);
                case 2: System.out.println("abc".charAt(3));
                case 3: System.out.println((Knight) new Swordman(Side.RED));
                case 4: System.out.println(((String) null).length());
            }
            System.out.printf("%d: 🎉 예외 없이 정상실행됨%n", i);

        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
            //  💡 둘 이상의 예외 타입들에 동일하게 대응할 때
            System.out.printf("%d : 🤮 범위를 벗어남%n", i);
        } catch (ClassCastException e) {
            System.out.printf("%d : 🎭 해당 클래스로 변환 불가%n", i);
        } catch (Exception e) {
            System.out.printf("%d : 🛑 기타 다른 오류%n", i);
        }
    }

    public static void main(String[] args) {
        // 모든 예외를 Exception으로 바로 처리
        IntStream.rangeClosed(0, 4)
                .forEach(Ex01::tryThings1);

        System.out.println("\n- - - - -\n");

        // 예외 발생의 처리를 상세하게 설정
        IntStream.rangeClosed(0, 4)
                .forEach(Ex01::tryThings2);

        System.out.println("\n- - - - -\n");

        // 비슷한 예외 상황을 똑같이 처리하기 위해 묶어서 처리
        IntStream.rangeClosed(0, 4)
                .forEach(Ex01::tryThings3);
    }
}
