package src.sec04.chap05.ex01;

import src.sec03.chap04.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer int1 = Integer.valueOf(1);
        Integer int2 = Integer.valueOf(2);
        Integer int3 = Integer.valueOf(3);

        //  대상보다 작을 때: -1, 같을 때 0, 클 때: 1
        int _1_comp_3 = int1.compareTo(3);
        int _2_comp_1 =  int2.compareTo(1);
        int _3_comp_3 =  int3.compareTo(3);
        int _t_comp_f = Boolean.valueOf(true).compareTo(Boolean.valueOf(false));
        int _abc_comp_def = "ABC".compareTo("DEF");
        int _def_comp_abc = "efgh".compareTo("abcd");

        Integer[] nums = {3, 8, 1, 7, 4, 9, 2, 6, 5};
        String[] strs = {
                "Fox", "Banana", "Elephant", "Car", "Apple", "Game", "Dice"
        };

        //  ⭐️ Arrays 클래스의 sort 메소드
        //  - 기본적으로 compareTo에 의거하여 정렬
        //  - 인자가 없는 생성자로 생성된 TreeSet, TreeMap도 마찬가지
        Arrays.sort(nums);
        Arrays.sort(strs);

        // 순서가 DESC 되어있는 것을 확인할 수 있다.
        // 즉, DESC방식으로 나열하고 싶다면 compare의 결과를 양수로 만들어라
        // 양수가 나오면 변경, 음수가 나오면 가만히
        Arrays.sort(nums, new IntDescComp());

        // 5를 기준으로 가까운 순으로 정렬
        Arrays.sort(nums, new CloseToInt(5));

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> numsAry = new ArrayList<>(Arrays.asList(nums));
        numsAry.sort(new IntDescComp());

        numsAry.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % 2) - (o2 % 2);
            }
        });

        // Unit TEST
        TreeSet<Unit> unitTSet = new TreeSet<>(new UnitSorter());
        unitTSet.addAll(Arrays.asList(new Knight(Side.BLUE),
                new Knight(Side.BLUE), // 중복
                new Swordman(Side.RED),
                new Swordman(Side.RED), // 중복
                new MagicKnight(Side.BLUE),
                new Swordman(Side.BLUE),
                new MagicKnight(Side.RED),
                new Knight(Side.RED)));
    }
}
