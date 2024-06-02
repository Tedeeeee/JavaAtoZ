package src.sec06.chap03;

import src.sec03.chap04.*;

public class Dragon extends Unit {
    public Dragon(Side side) {
        super(side, 3000);
    }

    @Override
    public String toString() {
        return side.toString() + " 진영 드래곤";
    }
}
