package src.sec03.chap01.ex03;

public class Main {
    public static void main(String[] args) {
        Click click1 = new Click(123, 456, 5323487);
        Click click2 = new Click(123, 456, 5323487);
        Click click3 = new Click(123, 456, 2693702);
        Click click4 = new Click(234, 567, 93827345);

        int click1Hash = click1.hashCode();
        int click2Hash = click2.hashCode();
        int click3Hash = click3.hashCode();
        int click4Hash = click4.hashCode();

        // Object의 toString은 내부에 hashCode메소드를 사용한다
        // hashCode를 Override하면 기본 toString에도 영향이 간다.
        String click1str = click1.toString();
        String click2str = click2.toString();
        String click3str = click3.toString();
        String click4str = click4.toString();

        System.out.println("click1str = " + click1str);
        System.out.println("click2str = " + click2str);
        System.out.println("click3str = " + click3str);
        System.out.println("click4str = " + click4str);

        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = new String("World");

        boolean boo1 = str1 == str2;

        // 문자열의 값도 같다면 해시값도 같도록 Override되어 있다.
        int str1Hash = str1.hashCode();
        int str2Hash = str2.hashCode();
        int str3Hash = str3.hashCode();

        // String 클래스는 toString 과 Equals가 구현이 되어 있다.
        String str1ToStr = str1.toString();
        boolean str1eq2 = str1.equals(str2);
        System.out.println("str1ToStr = " + str1ToStr);
        System.out.println("str1eq2 = " + str1eq2);
    }
}
