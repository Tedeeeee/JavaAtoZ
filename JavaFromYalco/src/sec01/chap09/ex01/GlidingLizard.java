package src.sec01.chap09.ex01;

import src.sec01.chap09.ex01.abstractType.Reptile;
import src.sec01.chap09.ex01.interfaceType.Flyer;
import src.sec01.chap09.ex01.interfaceType.Hunter;
import src.sec01.chap09.ex01.interfaceType.Swimmer;

public class GlidingLizard extends Reptile implements Hunter, Swimmer, Flyer {
    @Override
    public void fly() {
        System.out.println("날개막으로 활강");
    }

    @Override
    public void hunt() {
        System.out.println(position + " : 벌레 사냥");
    }

    @Override
    public void swim() {
        System.out.println("꼬리로 수영");
    }
}
