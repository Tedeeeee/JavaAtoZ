package src.sec02.chap03.ex01;

public class Main {
    public static void main(String[] args) {
        Outer.InnerSttcMember staticMember = new Outer.InnerSttcMember();
        staticMember.func();

        System.out.println("=========================");

        Outer outer = new Outer();
        outer.innerFuncs();

        System.out.println("=========================");

        Outer.InnerInstMember innerInstMember = outer.getInnerInstMember();
        innerInstMember.func();

        System.out.println("==========================");

        outer.memberFunc();
    }
}
