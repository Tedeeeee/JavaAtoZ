package src.sec01.chap05.ex01;

public class Main {
    public static void main(String[] args) {
        HadoonChickenDT dtStore = new HadoonChickenDT(108, "철원");

        dtStore.takeHallOrder();

        dtStore.takeDTOrder();
        dtStore.setDriveThruOpen(false);
        dtStore.takeDTOrder();
    }
}
