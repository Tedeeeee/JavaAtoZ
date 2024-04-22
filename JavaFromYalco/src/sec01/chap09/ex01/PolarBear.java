package src.sec01.chap09.ex01;

import src.sec01.chap09.ex01.abstractType.Mammal;
import src.sec01.chap09.ex01.interfaceType.Hunter;
import src.sec01.chap09.ex01.interfaceType.Swimmer;

public class PolarBear extends Mammal implements Hunter, Swimmer {
    public PolarBear() {
        super(false);
    }

    @Override
    public void hunt() {
        System.out.println(position + ": 물범 사냥");
    }

    @Override
    public void swim() {
        System.out.println("앞발로 수영 가능");
    }
}
