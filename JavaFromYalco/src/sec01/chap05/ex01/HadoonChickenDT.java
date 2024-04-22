package src.sec01.chap05.ex01;

public class HadoonChickenDT extends HadoonChicken{

    private boolean driveThruOpen = true;
    public HadoonChickenDT(int no, String name) {
        super(no, name);
    }

    public void setDriveThruOpen(boolean driveThruOpen) {
        this.driveThruOpen = driveThruOpen;
    }

    public void takeDTOrder() {
        System.out.printf("%d호 %s점 드라이브스루 주문 %s%n",
                no, name,
                (driveThruOpen ? "가능" : "불가"));
    }
}
