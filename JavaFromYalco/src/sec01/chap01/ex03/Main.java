package src.sec01.chap01.ex03;

public class Main {
    public static void main(String[] args) {
        //  클래스로 인스턴스를 생성 - 💡 new 연산자 + 생성자 호출
        //  본사의 방침대로 매장을 내는 것
        HadoonChicken store1 = new HadoonChicken(3, "판교");
        HadoonChicken store2 = new HadoonChicken(17, "강남");
        HadoonChicken store3 = new HadoonChicken(24, "제주");

        String[] intros = {store1.intro(), store2.intro(), store3.intro()};
        for (String intro : intros) {
            System.out.println(intro);
        }
    }
}
