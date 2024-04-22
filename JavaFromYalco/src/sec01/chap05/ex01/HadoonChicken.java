package src.sec01.chap05.ex01;

public class HadoonChicken {
    protected int no;
    protected String name;

    public HadoonChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void takeHallOrder() {
        System.out.printf("%d호 %s점 홀 주문 받음%n", no, name);
    }
}
