package src.sec01.chap08.ex01;

public class HadoonCafe extends HadoonGroup{

    public static String getCreed() {
        return CREED.formatted("원두향은");
    }

    protected static int lastNo = 0;
    private boolean isTakeout;

    public HadoonCafe(String name, boolean isTakeout) {
        super(++lastNo, name);
        this.isTakeout = isTakeout;
    }

    @Override
    public void takeOrder() {
        System.out.printf("얄코카페 %s 음료를 주문해주세요.%n", super.intro());
        if (!isTakeout) System.out.println("현재 테이크아웃은 불가능합니다. 매장에서 드셔야하는데 괜찮으세요?");
    }
}
