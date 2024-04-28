package src.sec02.chap03.ex01;

public class Outer {
    private String inst = "인스턴스";
    private static String sttc = "클래스";

    class InnerInstMember {
        private String name = inst + " 필드로써의 클래스";
    }
}
