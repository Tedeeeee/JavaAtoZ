package src.sec01.chap09.ex01;

import src.sec01.chap09.ex01.abstractType.Bird;
import src.sec01.chap09.ex01.interfaceType.Flyer;
import src.sec01.chap09.ex01.interfaceType.Hunter;

public class Eagle extends Bird implements Hunter, Flyer {
    @Override
    public void fly() {
        System.out.println("날개로 비행");
    }

    @Override
    public void hunt() {
        System.out.println(position + " : 토끼 사냥");
    }
}
