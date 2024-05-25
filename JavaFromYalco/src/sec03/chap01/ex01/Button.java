package src.sec03.chap01.ex01;

public class Button {
    public enum Mode {
        LIGHT("라이드"), DARK("다크");
        Mode(String indicator) {
            this.indicator = indicator;}
        String indicator;
    }

    private String name;
    private Mode mode;
    private int spaces;

    public Button(String name, Mode mode, int spaces) {
        this.name = name;
        this.mode = mode;
        this.spaces = spaces;
    }

//    @Override
//    public String toString() {
//        return "%s %s버튼 (%d칸 차지)"
//                .formatted(mode.indicator, name, spaces);
//    }
}
