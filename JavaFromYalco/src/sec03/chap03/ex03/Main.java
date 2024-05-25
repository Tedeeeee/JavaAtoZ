package src.sec03.chap03.ex03;

import src.sec01.chap09.ex01.Eagle;
import src.sec01.chap09.ex01.GlidingLizard;
import src.sec01.chap09.ex01.PolarBear;
import src.sec01.chap09.ex01.abstractType.Mammal;
import src.sec01.chap09.ex01.interfaceType.Flyer;
import src.sec01.chap09.ex01.interfaceType.Hunter;
import src.sec01.chap09.ex01.interfaceType.Swimmer;

public class Main {

    // T는 Number를 상속한 클래스이어야 한다.
    // Number의 밑에 있는 애들이 가능하다. Number보다 높은 조상은 사용할 수 없다.
    public static <T extends Number> double add2Num(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    // mamal, hunter, swimmer 를 상속받은 클래스는 사용할 수 있다.
    // 간단하게 적어본다면 T로써 들어오는 파라미터의 조건이 < > 안에 들어있는것이다.
    public static <T extends Mammal & Hunter & Swimmer> void descHuntingMamal(T animal) {
        System.out.printf("겨울잠 %s%n", animal.hibernation ? "잠" : "자지 않는다");
        animal.hunt();
    }

    // T의 타입이 Flyer 와 Hunter를 상속받은 클래스이기 떄문에 fly 메소드도 사용 가능
    public static <T extends Flyer & Hunter> void descFlyingHunter(T animal) {
        animal.fly();
        animal.hunt();
    }

    public static void main(String[] args) {
        double sum1 = add2Num(12, 34.56);

        // mamal, hunter, swimmer중 상속한게 있기 때문에 사용할 수 있다
        descHuntingMamal(new PolarBear());
        // fly를 상속받았기 때문에 이용할 수 없다.
        //descHuntingMamal(new GlidingLizard());

        descFlyingHunter(new Eagle());
        descFlyingHunter(new GlidingLizard());
        // 비슷한 이유로 fly를 상속받지 않았기 때문에 사용할 수 없다
        //descFlyingHunter(new PolarBear());
    }
}
