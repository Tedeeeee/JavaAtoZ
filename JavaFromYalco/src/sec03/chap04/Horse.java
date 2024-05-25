package src.sec03.chap04;

public class Horse<T extends Unit> {
    private int extraHp;
    private T rider;

    public Horse(int extraHp) {
        this.extraHp = extraHp;
    }

    // 말을 탄 병사는 말의 HP만큼 추가 체력
    public void setRider(T rider) {
        this.rider = rider;
        rider.hp += extraHp;
    }

    @Override
    public String toString() {
        return "말 (추가체력 : %d)".formatted(extraHp);
    }
}
