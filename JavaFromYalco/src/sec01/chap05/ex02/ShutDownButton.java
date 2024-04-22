package src.sec01.chap05.ex02;

public class ShutDownButton extends Button{
    public ShutDownButton() {
        super("ShutDown");
    }

    @Override
    public void func() {
        System.out.println("프로그램 종료");
    }
}
