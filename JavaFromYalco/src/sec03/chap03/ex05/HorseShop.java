package src.sec03.chap03.ex05;

public class HorseShop {

    // Unit을 상속받은 말은 모두 들어간다
    public static void intoBestSellers(Horse<? extends Unit> horse) {
        System.out.println("베스트셀러 라인에 추가 - " + horse);
    }

    // knight거나 상속받은 클래스만 받는다
    public static void intoPremiums(Horse<? extends Knight> horse) {
        System.out.println("프리미엄 라인에 추가 - " + horse);
    }

    // Knight거나 그의 위에 조상들만 받는다
    public static void intoEntryLevels(Horse<? super Knight> horse) {
        System.out.println("보급형 라인에 추가 - " + horse);
    }
}
