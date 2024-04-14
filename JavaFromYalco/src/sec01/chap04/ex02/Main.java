package src.sec01.chap04.ex02;

import src.sec01.chap04.ex01.SmartPhone;

public class Main {
    public static void main(String[] args) {
        // ex01 에서 제작된 smartPhone 이다
        SmartPhone smartPhone = new SmartPhone();
        // default 제어자는 사용 불가능
        String sdCardSlot = smartPhone.sdCardSlot;
    }
}
