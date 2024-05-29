package src.sec05.chap02;

import src.sec03.chap04.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.*;

/**
 *  Runnable = run()
 *  T Supplier<T> = get() -> 반환값이 T
 *  Consumer<T> = accept(T) -> 인자가 T
 *  BiConsumer<T, U> = accept(T, U) -> 두개의 값 모두 인자
 *  R Function<T, R> = apply(T) -> 인자는 T, 반환값은 R
 *  boolean Predicate<T> = test(T) -> 인자는 T, 반환값은 Boolean
 *  T Operator<T> = apply(T) -> 인자와 반환값이 모두 T
 */
public class Main {
    public static void main(String[] args) {
        // 밑의 sout은 run을 구현한 것이다. 인자도 반환값도 없다
        Runnable dogButtonFunc = () -> System.out.println("멍멍");
        Runnable catButtonFunc = () -> System.out.println("야옹");
        Runnable cowButtonFunc = () -> System.out.println("음메");

        dogButtonFunc.run();
        catButtonFunc.run();
        cowButtonFunc.run();

        System.out.println("\n- - - - - - -");

        Button dogButton = new Button("강아지");
        dogButton.setOnClickListener(dogButtonFunc);

        Button catButton = new Button("고양이");
        catButton.setOnClickListener(() -> {
            System.out.println("- - - - - - -");
            System.out.println(catButton.getText() + "울음소리 : 야옹야옹");
            System.out.println("- - - - - - -");
        });

        dogButton.onClick();
        catButton.onClick();

        // supplier는 제공자 즉, 반환값만 존재한다.
        // 반환값이 제네릭에 들어가 있다.
        Supplier<String> appName = () -> "얄코오피스";
        Supplier<Double> rand0to10 = () -> Math.random() * 10;
        Supplier<Boolean> randTF = () -> Math.random() > 0.5;

        String supp1 = appName.get();
        Double supp2 = rand0to10.get();
        Boolean supp3 = randTF.get();

        System.out.println("\n- - - - - - -");

        // Consumer 는 소비자 즉, 인자값만이 존재한다.
        // 인자로 전달하는 값이 제네릭에 들어가있다
        Consumer<Integer> sayOddEven = i -> System.out.printf(
                "%d은 %c수입니다.%n", i, "짝홀".charAt(i % 2)
        );

        Consumer<Button> clickButton = b -> b.onClick();

        BiConsumer<Button, Integer> clickButtonNTimes = (b, n) -> {
            for (int i = 0; i < n; i++) b.onClick();
        };

        sayOddEven.accept(3);
        sayOddEven.accept(4);
        clickButton.accept(catButton);
        clickButtonNTimes.accept(dogButton, 5);

        System.out.println("\n- - - - - - -");

        // Function는 두개의 값을 받고 앞에것이 인자 뒤에가 반환값이다.
        Function<Integer, Boolean> isOdd = i -> i % 2 == 1;
        Function<String, Button> getButton = s -> new Button(s);

        // 3개의 인자를 받고
        // 앞의 2개는 인자, 마지막 한개의 값이 반환값이다.
        BiFunction<Unit, Horse, Integer> getfullHP = (u, h) -> {
            h.setRider(u);
            return u.hp;
        };

        BiFunction<String, Runnable, Button> getButtonWFunc = (s, r) -> {
            Button b = new Button(s);
            b.setOnClickListener(r);
            return b;
        };

        Boolean isOdd3 = isOdd.apply(3);
        Boolean isOdd4 = isOdd.apply(4);

        Button goatButton = getButton.apply("염소");

        Integer unitFullHP = getfullHP.apply(
                new MagicKnight(Side.RED), new Horse(80)
        );

        getButtonWFunc.apply("오리", () -> System.out.println("꽥꽥"))
                .onClick();

        System.out.println("\n- - - - - - -");

        // Predicate 는 Boolean를 반환받는것이 고정이다
        // T는 인자값이다.
        Predicate<Integer> isOddTester = i -> i % 2 == 1;
        Predicate<String> isAllLowerCase = s -> s.equals(s.toLowerCase());

        // 반환값은 무조건 Boolean이기 때문에 두개의 모두 파라미터의 역할을 한다
        BiPredicate<Character, Integer> areSameCharNum = (c, i) -> (int) c == i;
        BiPredicate<Unit, Unit> areSameSide = (u1, u2) -> u1.getSide() == u2.getSide();

        boolean isOddT3 = isOddTester.test(3);
        boolean isOddT4 = isOddTester.test(4);
        boolean isAL1 = isAllLowerCase.test("Hello");
        boolean isAL2 = isAllLowerCase.test("world");

        boolean areSameCN1 = areSameCharNum.test('A', 64);
        boolean areSameCN2 = areSameCharNum.test('A', 65);

        boolean areSameSide1 = areSameSide.test(
                new Knight(Side.RED), new Knight(Side.BLUE)
        );

        boolean areSamSide2 = areSameSide.test(
                new Swordman(Side.BLUE), new MagicKnight(Side.BLUE)
        );

        System.out.println("\n- - - - - - -");

        //Operation은 인자와 반환값이 모두 같다
        UnaryOperator<Integer> square = i -> i * i;
        // 반환값이 swordman임에도 Magic, Knight의 반환값을 가질 수 있는것도 다형성 덕분
        UnaryOperator<Swordman> respawn = s -> {
            if (s instanceof MagicKnight) return new MagicKnight(s.getSide());
            if (s instanceof Knight) return new Knight(s.getSide());
            return new Swordman(s.getSide());
        };

        Integer squared = square.apply(3);
        Swordman respawned1 = respawn.apply(new Knight(Side.BLUE));
        Swordman respawned2 = respawn.apply(new MagicKnight(Side.RED));

        System.out.println("\n- - - - - - -");

        BinaryOperator<Double> addTwo = (i, j) -> i + j;
        BinaryOperator<Swordman> getWinner = (s1, s2) -> {
            while (s1.hp > 0 && s2.hp > 0) {
                s1.defaultAttack(s2);
                s2.defaultAttack(s1);
                if (s1 instanceof MagicKnight) {
                    ((MagicKnight) s1).lighteningAttack(new Swordman[] {s2});
                }
                if (s2 instanceof MagicKnight) {
                    ((MagicKnight) s2).lighteningAttack(new Swordman[] {s1});
                }
            }

            if (s1.hp > 0) return s1;
            if (s2.hp > 0) return s2;
            return null;
        };

        Double added = addTwo.apply(12.34, 23.45);

        Swordman winner1 = getWinner.apply(new Swordman(Side.RED), new Knight(Side.BLUE));
        Swordman winner2 = getWinner.apply(new MagicKnight(Side.RED), new Knight(Side.BLUE));
        Swordman winner3 = getWinner.apply(new Swordman(Side.RED), new MagicKnight(Side.BLUE));
        Swordman winner4 = getWinner.apply(new MagicKnight(Side.RED), new MagicKnight(Side.BLUE));

        System.out.println("\n- - - - - - -");


        /**
         *  Iterable 인터페이스의 forEach 메소드
         *  스트림의 forEach 와는 다르다.
         *  Consumer를 인자로 받아 실행한다
         *  이터레이터를 쓸 수 있는 클래스에서 사용이 가능하다
         */
        new ArrayList<>(
                Arrays.asList("하나", "둘", "셋", "넷", "다섯")
        ).forEach(s -> System.out.println(s));

        System.out.println("\n- - - - - - -");

        HashMap<String, Character> subjectGradeHM = new HashMap<>();
        subjectGradeHM.put("English", 'B');
        subjectGradeHM.put("Math", 'C');
        subjectGradeHM.put("Programming", 'A');

        // BiConsumer를 받는다
        subjectGradeHM.forEach(
                (s, g) -> System.out.printf(
                        "%s : %c%n".formatted(s, g)
                )
        );
    }
}
