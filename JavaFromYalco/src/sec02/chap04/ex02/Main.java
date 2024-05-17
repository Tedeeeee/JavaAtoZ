package src.sec02.chap04.ex02;

public class Main {
    public static void main(String[] args) {
        Button button1 = new Button("Enter");
        Button button2 = new Button("CapsLock");
        Button button3 = new Button("ShutDown");

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("줄바꿈");
                System.out.println("커서를 다음 줄에 위치시킨다.");
            }
        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("기본 입력 대소문자 전환");
            }
        });

        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("작업 자동 저장");
                System.out.println("프로그램 종료");
            }
        });

        for (Button button : new Button[] {button1, button2, button3}) {
            button.func();
        }
    }
}
