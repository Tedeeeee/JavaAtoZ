package src.sec05.chap02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

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
    }
}
