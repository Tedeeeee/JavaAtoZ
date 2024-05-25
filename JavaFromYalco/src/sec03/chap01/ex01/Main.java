package src.sec03.chap01.ex01;


public class Main {
    public static void main(String[] args) {
        Button button1 = new Button("엔터", Button.Mode.DARK, 3);

        // 메소드를 ctrl / command + 클릭하여 Object 클래스 사양보기
        // toString 을 따로 구현하지 않으면 주소값이 출력된다
        // toString 을 구현하면 그 내용을 기반으로 출력
        System.out.println(button1);
    }
}
