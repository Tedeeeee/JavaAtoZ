package src.sec01.chap05.ex02;

public class Main {
    public static void main(String[] args) {
        Button entrButton = new Button("Enter");
        ShutDownButton stdnButton = new ShutDownButton();
        ToggleButton tglButton = new ToggleButton("CapsLock", false);

        entrButton.func();

        System.out.println("===========");

        stdnButton.func();

        System.out.println("===========");

        tglButton.func();
        tglButton.func();
        tglButton.func();
    }
}
