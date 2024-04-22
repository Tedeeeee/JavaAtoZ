package src.sec01.chap06.ex01;

import src.sec01.chap05.ex02.Button;
import src.sec01.chap05.ex02.ShutDownButton;
import src.sec01.chap05.ex02.ToggleButton;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button("Enter");
        Button button2 = new ShutDownButton();
        Button button3 = new ToggleButton("CapsLock", true);

        // 부 -> 자는 가능하지만 반대로는 불가
        // 자식들은 서로 정보를 나눌수 없다

        Button[] buttons = {
                new Button("Space"),
                new ToggleButton("NumLock", false),
                new ShutDownButton()
        };

        for (Button button : buttons) {
            button.func();
        }

        Button button = new Button("버튼");
        ToggleButton toggleButton = new ToggleButton("토글", true);
        ShutDownButton shutDownButton = new ShutDownButton();

        boolean typeCheck1 = button instanceof Button;
        boolean typeCheck2 = shutDownButton instanceof Button;
        boolean typeCheck3 = toggleButton instanceof Button;


        boolean typeCheck4 = button instanceof ToggleButton;
        boolean typeCheck5 = button instanceof ShutDownButton;

        // 자식들끼리는 당연히 안된다.

        System.out.println("============");
        for (Button btn : buttons) {
            if (btn instanceof ShutDownButton) continue;
            btn.func();
        }
    }
}
