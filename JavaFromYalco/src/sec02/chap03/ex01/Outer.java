package src.sec02.chap03.ex01;

public class Outer {
    private String inst = "인스턴스";
    private static String sttc = "클래스";

    // 멤버 인스턴스 클래스
    class InnerInstMember {
        // 외부 클래스의 필드와 클래스 접근 가능하다
        private String name = inst + " 필드로써의 클래스";
        private InnerSttcMember innerSttcMember = new InnerSttcMember();

        public void func() {
            System.out.println(name);
        }
    }

    // 정적 내부 클래스
    // 내부 클래스에도 접근자 사용 가능하다.
    public static class InnerSttcMember {
        // 외부 클래스의 클래스 필드만 접근 가능하다
        private String name = sttc + " 필드로써의 클래스";

        // static 이 아닌 멤버 인스턴스 클래스에도 접근이 블가능하다
        // private InnerInstMember innerInstMember = new InnerInstMember();

        public void func() {
            System.out.println(name);
        }
    }

    public void memberFunc() {
        // 메소드 안에 정의된 클래스
        class MethodMember {
            String instSttc = inst + " " + sttc;
            InnerInstMember innerInstMember = new InnerInstMember();
            InnerSttcMember innerSttcMember = new InnerSttcMember();

            public void func() {
                innerInstMember.func();
                innerSttcMember.func();
                System.out.println("메소드 안의 클래스");
            }
        }

        new MethodMember().func();
    }

    public void innerFuncs() {
        new InnerInstMember().func();
        new InnerSttcMember().func();
    }

    public InnerInstMember getInnerInstMember() {
        return new InnerInstMember();
    }
}
