package src.sec07.chap04.ex01;

import java.util.Random;

public class ATM {
    private int balance = 0;

    public void addMoney(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    // 메소드 앞에 synchronized를 붙이면 다르다
    public synchronized void withdraw(String name, int amount) {
        // 여기서 this는 현 쓰레드를 의미한다
        // 메소드 내의 특정 작업만 동기화가 필요할 때 사용하면 된다
        //synchronized (this) {}

        if (balance < amount) return;

        System.out.printf(
                "💰 %s 인출 요청 (현 잔액 %d)%n",
                name, balance
        );

        try {
            Thread.sleep(new Random().nextInt(700, 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        balance -= amount;
        System.out.printf(
                "✅ %s 인출 완료 (현 잔액 %d)%n",
                name, balance
        );
    }
}
