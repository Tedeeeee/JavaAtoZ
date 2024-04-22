package src.sec01.chap08.ex01;

public class Main {
    public static void main(String[] args) {
        // abstract class 는 인스턴스화 할 수 없다
        // HadoonGroup hadoonGroup = new HadoonGroup(1, "서울");

        HadoonChicken hdcStore1 = new HadoonChicken("판교");
        HadoonChicken hdcStore2 = new HadoonChicken("강남");

        HadoonCafe hdfStore1 = new HadoonCafe("울릉", true);
        HadoonCafe hdfStore2 = new HadoonCafe("강릉", false);

        HadoonGroup[] stores = {
                hdcStore1, hdcStore2,
                hdfStore1, hdfStore2
        };

        for (HadoonGroup hdStore : stores) {
            hdStore.takeOrder();
        }

        System.out.println("===========");

        System.out.println(HadoonChicken.CREED);
        System.out.println(HadoonCafe.CREED);

    }
}
