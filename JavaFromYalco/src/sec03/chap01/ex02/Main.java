package src.sec03.chap01.ex02;

public class Main {
    public static void main(String[] args) {
        Click click1 = new Click(123, 456, 5323487);
        Click click2 = new Click(123, 456, 5323487);
        Click click3 = new Click(123, 456, 2693702);
        Click click4 = new Click(234, 567, 93827345);

        for (Click click : new Click[] {click1, click2, click3, click4}) {
            System.out.println(click);
        }

        // == 는 주소를 비교
        boolean bool1 = click1 == click1;
        boolean bool2 = click1 == click2;
        boolean bool3 = click1 == click3;
        boolean bool4 = click1 == click4;

        // equals 는 값을 비교
        boolean boolA = click1.equals(click1);
        boolean boolB = click1.equals(click2);
        boolean boolC = click1.equals(click3);
        boolean boolD = click1.equals(click4);

        /**
         * equal은 값을 비교하는 것으로 알고 있지만 Click 처럼 직접 만든 객체를 비교하면
         * == 과 equals는 같은 행위를 한다.
         *
         * 때문에 만약 값을 비교하고자 한다면 직접 Override를 통해 구현하면 equals를 값을 비교하기 위해 사용된다.
         */

        System.out.println("bool1 = " + bool1);
        System.out.println("bool2 = " + bool2);
        System.out.println("bool3 = " + bool3);
        System.out.println("bool4 = " + bool4);
        System.out.println("boolA = " + boolA);
        System.out.println("boolB = " + boolB);
        System.out.println("boolC = " + boolC);
        System.out.println("boolD = " + boolD);
    }
}
