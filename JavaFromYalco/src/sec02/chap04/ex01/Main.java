package src.sec02.chap04.ex01;

import src.sec01.chap08.ex01.HadoonCafe;
import src.sec01.chap08.ex01.HadoonChicken;
import src.sec01.chap08.ex01.HadoonGroup;

public class Main {
    public static void main(String[] args) {
        HadoonGroup store1 = new HadoonChicken("울산");
        HadoonGroup store2 = new HadoonCafe("창원", true);
    }
}
