package src.sec07.chap04.ex01;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addMoney(5000);

        Thread thr1 = new Thread(
                new CustomRun("철수", atm, 500)
        );

        Thread thr2 = new Thread(
                new CustomRun("영희", atm, 300)
        );

        Thread thr3 = new Thread(
                new CustomRun("돌준", atm, 400)
        );

        // 3개의 쓰레드가 동시에 실행되면서 ATM의 잔액을 각자 읽는 타이밍이 같다
        // 때문에 Syncronized를 메소드에 담아서 확인해야한다.
        thr1.start();
        thr2.start();
        thr3.start();

        // 인출하는 순서는 보장할 수 없어도 잔액은 보장이 가능하다
        // syncronized는 동시성의 문제를 해결할 수 있다.
    }
}
