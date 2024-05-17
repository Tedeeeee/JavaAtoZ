package src.sec02.chap07.ex02;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        // record 데이터는 static을 붙여주지 않아도 마치 static 처럼 동작한다.
        Button.ClickInfo click1 = button.func(123, 456, Button.ClickedBy.LEFT);
        Button.ClickInfo click2 = button.func(492, 97, Button.ClickedBy.LEFT);
        Button.ClickInfo click3 = button.func(12, 36, Button.ClickedBy.RIGHT);

        for (Button.ClickInfo clickInfo : new Button.ClickInfo[] {click1, click2, click3}) {
            clickInfo.printInfo();
        }

        System.out.println("\n- - - - - - -\n");

        Button.ClickInfo click4 = button.func(111, 222, Button.ClickedBy.LEFT);
        Button.ClickInfo click5 = button.func(111, 222, Button.ClickedBy.LEFT);

        // record 데이터는 참조형이다. 내용이 같은지는 equals로 확인한다
        // 주소가 다르기 때문에 false
        boolean click4n5Same = click4 == click5;
        // 주소가 다르지만 값이 같기 때문에 true
        boolean click4n5Equal = click4.equals(click5);
        // 값도 주소도 다르다.
        boolean click4n1Equal = click4.equals(click1);

        System.out.println("click4n5Same = " + click4n5Same);
        System.out.println("click4n5Equal = " + click4n5Equal);
        System.out.println("click4n1Equal = " + click4n1Equal);
    }
}
