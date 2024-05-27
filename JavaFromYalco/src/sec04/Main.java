package src.sec04;

import src.sec03.chap04.Knight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ints1 = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Knight> knights = new ArrayList<>();

        ints1.add(11);
        ints1.add(22);
        ints1.add(33);
        ints1.add(44);
        ints1.add(55);

        for (String str : "바니 바니 바니 바니 당근 당근".split(" ")) {
            strings.add(str);
        }

        for (int i : ints1) {
            System.out.println(i);
        }

        int ints1Size = ints1.size();
        boolean intsIsEmpty = ints1.isEmpty();
        Integer ints12nd = ints1.get(1);
        boolean ints1Con3 = ints1.contains(33);
        boolean ints1Con6 = ints1.contains(66);

        ints1.set(2, 444); // 배열의 위치에 있는 값 수정
        ints1.add(0, 11); // 해당 위치의 요소를 추가하는 것 (기존의 요소는 모두 shift)

        // 간략한 생성 및 초기화 방법
        // Arrays 클래스 : 배열 관련 각종 기능을 제공한다.
        ArrayList<Integer> ints2A = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5)
        );

        // List를 사용한 입력 -> 자바 9에서부터 가능
        ArrayList<Integer> ints2B = new ArrayList<>(
                List.of(1, 2, 3, 4, 5)
        );

        ArrayList<Integer> ints2C = new ArrayList<>();
        Collections.addAll(ints2C, 1, 2, 3, 4, 5);

        // 다른 Collection 인스턴스를 사용해서 생성한다
        ArrayList<Integer> ints3 = new ArrayList<>(ints1);

        ArrayList<Integer> ints4 =(ArrayList<Integer>) ints3.clone();

        ints3.remove(4);
        ints3.remove((Integer) 55);

        // 주어진 콜렉션에 있는 요소들을 지운다
        ints1.removeAll(ints3);

        // 콜렉션을 이어 붙인다.
        ints1.addAll(ints3);
    }
}
