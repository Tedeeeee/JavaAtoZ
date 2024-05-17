package src.sec02.chap04.ex01;

import src.sec01.chap08.ex01.*;

public class Main {
    public static void main(String[] args) {
        HadoonGroup store1 = new HadoonChicken("울산");
        HadoonGroup store2 = new HadoonCafe("창원", true);

        HadoonGroup store3 = new HadoonGroup(1, "포항") {
            @Override
            public void takeOrder() {
                System.out.printf(
                        "유일한 얄코과메기 %s 과메기를 주문해주세요. %n",
                        super.intro()
                );
            }

            // 익명 클래스의 인스턴스는 상속 받거나 오버라이드 된 메소드만이 호출이 가능하다.
            public void dryFish() {
                System.out.println("과메기 말리기");
            }
        };

        String store3Intro = store3.intro();
        store3.takeOrder();

        for (HadoonGroup store : new HadoonGroup[] {store1, store2, store3}) {
            store.takeOrder();
        }
    }
}
