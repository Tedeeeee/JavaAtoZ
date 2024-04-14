package src.sec01.chap01.ex02;

public class Main {
    public static void main(String[] args) {
        HadoonChicken store1 = new HadoonChicken();
        store1.no = 3;
        store1.name = "판교";

        HadoonChicken store2 = new HadoonChicken();
        store2.no = 16;
        store2.name = "강남";

        int store1No = store1.no;
        String store2Name = store2.name;

        String store1Intro = store1.intro();
        System.out.println(store1Intro);
    }
}
