package src.sec01.chap09.ex01;

import src.sec01.chap09.ex01.abstractType.Mammal;
import src.sec01.chap09.ex01.interfaceType.Hunter;
import src.sec01.chap09.ex01.interfaceType.Swimmer;

public class Main {
    public static void main(String[] args) {
        PolarBear polarBear = new PolarBear();
        Mammal mammal = polarBear;
        Swimmer swimmer = polarBear;

        GlidingLizard glidingLizard = new GlidingLizard();
        Eagle eagle = new Eagle();

        Hunter[] hunters = {
                polarBear, glidingLizard, eagle
        };

        for (Hunter hunter : hunters) {
            hunter.hunt();
        }
    }
}
