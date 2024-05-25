package src.sec03.chap03.ex05;

// Unit을 상속받은 타입(클래스)만을 받을 수 있다.
public class Horse <T extends Unit>{
    private T rider;

    public void setRider(T rider) {
        this.rider = rider;
    }
}
