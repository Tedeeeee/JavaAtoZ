package src.sec05.chap03;

public class Button {
    private String text;
    public Button(String text) {
        this.text = text;}

    public Button(String text, String sound) {
        this(text);
        // onClickListener의 run을 구현
        onClickListener = () -> System.out.println(sound + " " + sound);
    }

    private Runnable onClickListener;

    public void setOnClickListener(Runnable onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        onClickListener.run();
    }
}
