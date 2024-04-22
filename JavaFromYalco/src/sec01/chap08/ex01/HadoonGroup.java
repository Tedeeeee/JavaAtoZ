package src.sec01.chap08.ex01;

public abstract class HadoonGroup {

    // 클래스 메서드는 abstract가 불가능하다
    // static 은 초기화가 되어야 하는데 추상 클래스는 초기화하지 않느다.
    // ex ) static 붙은 클래스

    protected static final String CREED = "우리의 %s 얄팍하다";

    protected final int no;
    protected final String name;
    public HadoonGroup(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String intro() {
        return "%d호 %s점입니다.".formatted(no, name);
    }

    public abstract void takeOrder();
}
