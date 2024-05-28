package src.sec04.chap06;

import src.sec03.chap04.*;

import java.util.*;

public class Main {
    /**
     *  컬렉션을 순회하는 용도로 사용
     *  - 투어가이드, 순시 감찰관 역할
     *  - 특정 기준의 요소들 제거에 유용하다
     *  - 순회 상태가 저장될 필요가 있을 때 유용하다
     */

    public static void main(String[] args) {
        Set<Integer> intHSet = new HashSet<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
        );

        // 이터레이터 반환 및 초기화
        // - 기타 Collection 인터페이스를 구현한 클래스들에도 존재한다.
        Iterator<Integer> intItor = intHSet.iterator();

        Integer int1 = intItor.next();
        Integer int2 = intItor.next();
        Integer int3 = intItor.next();

        boolean hasNext = intItor.hasNext();

        // remove 는 현 위치의 요소를 삭제하는 것
        while (intItor.hasNext()) {
            if (intItor.next() % 3 == 0) intItor.remove();
        }

        // foreach 문으로 시도하면 오류 발생
        // foreach 문에서 Collection의 데이터를 삭제하는 것은 금지되어 있다
        // Concurrent 문제 때문에
//        for (Integer num : intHSet) {
//            if (num % 3 == 0) intHSet.remove(num);
//        }

        List<Unit> enemies = new ArrayList<>(
                Arrays.asList(
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new Swordman(Side.RED),
                        new Knight(Side.RED),
                        new Knight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Swordman(Side.RED),
                        new MagicKnight(Side.RED),
                        new Knight(Side.RED),
                        new MagicKnight(Side.RED))
        );

        Iterator<Unit> enemyItor = enemies.iterator();

        int thunderBolts = 3;
        int fireBalls = 4;

        while (enemyItor.hasNext() && thunderBolts-- > 0) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 벼락 공격%n", enemy);
            enemy.hp -= 50;
        }

        while (enemyItor.hasNext() && fireBalls-- > 0) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 파이어볼 공격%n", enemy);
            enemy.hp -= 30;
        }

        while (enemyItor.hasNext()) {
            Unit enemy = enemyItor.next();
            System.out.printf("%s 화살 공격%n", enemy);
            enemy.hp -= 10;
        }

        System.out.println("\n- - - - - -\n");

        HashMap<Integer, Double> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i + 1, Math.floor(Math.random() * 10));
        }

        Iterator<Integer> hmKeyItor = hashMap.keySet().iterator();
        Iterator<Double> hmValueItor = hashMap.values().iterator();
        Iterator<Map.Entry<Integer, Double>> hmEntryItor = hashMap.entrySet().iterator();

//        while (hmKeyItor.hasNext()) {
//            System.out.println(hmKeyItor.next());
//        }
//        System.out.println("\n- - - - -\n");
//
//        while (hmValueItor.hasNext()) {
//            System.out.println(hmValueItor.next());
//        }
//        System.out.println("\n- - - - -\n");
//
//        while (hmEntryItor.hasNext()) {
//            System.out.println(hmEntryItor.next());
//        }

        // 이들은 따로 반환된 컬렉션의 이터레이터
        // - 여기서 remove 하는 것은 원본 데이터에 영향을 끼치지 않는다.
        while (hmEntryItor.hasNext()) {
            Map.Entry<Integer, Double> entry = hmEntryItor.next();
            int key = entry.getKey();
            double value = entry.getValue();
            if (key % 3 == 0 || key % 2 == 0 || value < 5) {
                hmEntryItor.remove(); // 안전하게 요소 제거
            }
        }

        System.out.println("최종 상태:");
        for (Map.Entry<Integer, Double> entry : hashMap.entrySet()) {
            System.out.printf("%d: %.1f%n", entry.getKey(), entry.getValue());
        }
    }
}
