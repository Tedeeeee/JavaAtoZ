package src.sec06.chap06;

import java.util.Random;

/**
 *  NullPointException
 *  - null인 것으로부터 필드나 메소드 등을 호출하려 할 때 발생한다
 *  - 컴파일러 선에선 방지하지 못한다
 */
public class Ex01 {
    public static String catOrNull() {
        // 슈뢰딩거의 고양이
        return new Random().nextBoolean() ? "Cat" : null;
    }

    public static void main(String[] args) {
        String nulStr = null;
        // 여기서 NullPointException이 발생한다.
        // 이유는 null의 길이를 재려고 하기 때문
        // System.out.println(nulStr.length());

        // 1/2 확률로 cat이 나올수도 null이 발생할수도 있음
        // 때문에 이 코드는 try문으로 감싸서 보호해야한다
        // System.out.println(catOrNull().length());

        try {
            System.out.println(catOrNull().length());
        } catch (NullPointerException ne) {
            ne.printStackTrace();
            System.out.println(0);
        }

    }

}
