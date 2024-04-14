package src.sec01.chap03.ex02;

public class Main {
    public static void main(String[] args) {
        HadoonChicken store1 = new HadoonChicken("판교");
        HadoonChicken store2 = new HadoonChicken("강남");
        HadoonChicken store3 = new HadoonChicken("제주");

        String intro1 = store1.intro();
        String intro2 = store2.intro();
        String intro3 = store3.intro();
    }
}
