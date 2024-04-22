package src.sec01.chap06.ex03;

import src.sec01.chap05.ex01.HadoonChicken;
import src.sec01.chap05.ex02.Button;
import src.sec01.chap05.ex02.ShutDownButton;
import src.sec01.chap05.ex03.FireSlime;

public class Main {
    public static void main(String[] args) {
        Object obj1 = new Object();

        Object obj2 = new HadoonChicken(3, "판교");
        Object obj3 = new ShutDownButton();
        Object obj4 = new FireSlime();

        Object obj5 = true;
        Object obj6 = 1;
        Object obj7 = "Hello";

        Object[] objs = {
                1, false, 3.45, '가', "안녕하세요", new Button("Space")
        };

        for (Object obj : objs) {
            System.out.println(obj);
        }
    }
}
