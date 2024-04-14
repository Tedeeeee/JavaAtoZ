package src.sec01.chap02.ex03;

public class ChickenMenu {
    String name;
    int price;
    String cook = "fry";

    public ChickenMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public ChickenMenu(String name, int price, String cook) {
        this.name = name;
        this.price = price;
        this.cook = cook;
    }
}
