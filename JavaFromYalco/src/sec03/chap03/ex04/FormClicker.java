package src.sec03.chap03.ex04;

public class FormClicker <T extends FormElement & Clickable> {
    private T formElem;

    public FormClicker(T formElem) {
        this.formElem = formElem;
    }

    // 조건의 클래스와 인터페이스의 기능을 사용 가능하다
    // 자료형의 범위를 특정해줄수 있다
    public void printElemMode() {
        formElem.printMode();
    }

    public void clickElem() {
        formElem.onClick();
    }
}
