package src.sec01.chap03.ex01;


public class Main {
    public static void main(String[] args) {
        String hdBrand = HadoonChicken.brand;
        String hdContact = HadoonChicken.contact();

        HadoonChicken store1 = new HadoonChicken(3, "판교");
        String st1Intro = store1.intro();


    }
}
