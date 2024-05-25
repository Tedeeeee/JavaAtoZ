package src.sec03.chap03.ex01;

import src.sec02.chap03.ex02.HadoonChicken;

public class Main {

    // 제네릭 메소드
    // T : 타입 변수, 원하는 어떤 이름으로든 명명이 가능하다.
    public static <T> T pickRandom(T a, T b) {
        return Math.random() > 0.5 ? a : b;
    }

    public static <T> void arraySwap(T[] array, int a, int b) {
        if (array.length <= Math.max(a, b)) return;
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        int randNum = pickRandom(123, 456);
        boolean randBool = pickRandom(true, false);
        String randStr = pickRandom("마루치", "아라치");

        HadoonChicken store1 = new HadoonChicken("판교");
        HadoonChicken store2 = new HadoonChicken("역삼");
        // 생성한 객체의 타입을 넣어도 T이기 때문에
        HadoonChicken randStore = pickRandom(store1, store2);

        // 타입이 일관되지 않고 묵시적 변환 불가하면 오류
        //double s = pickRandom("hello", "world");

        double randDb1 = pickRandom(12, 34);

        Double[] array1 = new Double[] {
                1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8
        };

        Character[] array2 = new Character[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'
        };

        arraySwap(array1, 3, 5);
        arraySwap(array2, 2, 7);

        for (int i = 0; i < 100; i++) {
            arraySwap(
                    array2,
                    (int) Math.floor(Math.random() * array2.length),
                    (int) Math.floor(Math.random() * array2.length)
            );
        }
    }


}
