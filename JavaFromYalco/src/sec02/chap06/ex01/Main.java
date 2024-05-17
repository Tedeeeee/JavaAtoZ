package src.sec02.chap06.ex01;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button();

        button1.setButtonMode(ButtonMode.DARK);
        button1.setButtonSpace(ButtonSpace.TRIPLE);

        // 아래와 같이 잘못된 설정이 방지된다
        // button1.setButtonMode(ButtonSpace.DOUBLE);
    }
}
