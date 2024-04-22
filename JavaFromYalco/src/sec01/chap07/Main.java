package src.sec01.chap07;

public class Main {
    public static void main(String[] args) {
        String hdCrees = HadoonChicken.CREED;
        // 불가능
        // HadoonChicken.CREED = "우리의 튀김옷은 바싹쓰하다";

        final HadoonChicken store = new HadoonChicken(3, "판교");

        //  ⚠️ 불가
        // store = new HadoonChicken(17, "강남");

        //  💡 요소 변경은 가능
        store.name = "선릉";


    }
}
