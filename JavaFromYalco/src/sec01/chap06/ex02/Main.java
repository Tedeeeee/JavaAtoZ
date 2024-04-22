package src.sec01.chap06.ex02;

import src.sec01.chap05.ex01.HadoonChicken;
import src.sec01.chap05.ex01.HadoonChickenDT;

public class Main {
    public static void main(String[] args) {
        HadoonChickenDT dtStore = new HadoonChickenDT(108, "철원");

        dtStore.takeHallOrder();

        dtStore.takeDTOrder();
        dtStore.setDriveThruOpen(false);
        dtStore.takeDTOrder();

        System.out.println("=================");

        HadoonChicken[] hdStores = {
                new HadoonChicken(3, "판교"),
                new HadoonChicken(17, "강남"),
                new HadoonChickenDT(108, "철원")
        };

        for (HadoonChicken store : hdStores) {
            if (store instanceof HadoonChickenDT) {
                ((HadoonChickenDT) store).takeDTOrder();
            } else {
                store.takeHallOrder();
            }
        }
    }
}
