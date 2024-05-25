package src.sec03.chap01.ex04;

public class NotCloneable {
    // 원시 타입
    String titls;
    int no;

    // 참조 타입
    int[] numbers;
    Click click;
    Click[] clicks;

    public NotCloneable(String titls, int no, int[] numbers, Click click, Click[] clicks) {
        this.titls = titls;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // super의 clone : 필드들을 얕은 복사 해주는 Object 메소드
        // - 원시 타입은 확실히 복사한다. 참조타입은 참조복사로 이루어진다.

        // Cloneable을 구현하지 않는 클래스에서 호출하면 오류가 발생한다
        // - clone을 Override해서 쓰는 의미가 없다.
        // - 어차피 일일히 값을 비교하는 것이라면 의미가 없기 때문이다.
        return super.clone();
    }
}
