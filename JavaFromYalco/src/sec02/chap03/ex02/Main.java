package src.sec02.chap03.ex02;

public class Main {
    public static void main(String[] args) {
        HadoonChicken.LaunchTF launchTF1 = new HadoonChicken.LaunchTF("마산", "김영희");
        HadoonChicken.LaunchTF launchTF2 = new HadoonChicken.LaunchTF("영월", "이철수");

        HadoonChicken store1 = launchTF1.launch();
        HadoonChicken store2 = launchTF2.launch();

        HadoonChicken.Gift[] gifts = {
                store1.getGift("홍길동"),
                store1.getGift("전우치"),
                store2.getGift("옥동자")
        };


    }
}
