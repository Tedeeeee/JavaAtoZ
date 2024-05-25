package src.sec03.chap01.ex04;

import java.util.Arrays;

public class DeepCopied implements Cloneable{
    String title;
    int no;

    int[] numbers;
    Click click;
    Click[] clicks;

    public DeepCopied(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 기존에 가벼운 복사를 먼저 실행
        DeepCopied clone = (DeepCopied) super.clone();

        // 참조 타입을 복사하는 것을 요소들을 하나하나 복사해서 직접 넣기
        clone.numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            clone.numbers[i] = numbers[i];
        }

        clone.click = new Click(click.x, click.y);

        // 이중 참조
        clone.clicks = new Click[clicks.length];
        for (int i = 0; i < clicks.length; i++) {
            clone.clicks[i] = new Click(clicks[i].x, clicks[i].y);
        }

        return clone;
    }
}
