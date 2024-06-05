package src.sec07.chap05.ex02;

public class CoffeeMachine {
    final int CUP_MAX = 10;
    int cups = CUP_MAX;

    synchronized public void takeout(CustomerRun customer) {
        if (cups < 1) {
            System.out.printf(
                    "[%d] 😭 %s 커피 없음%n", cups, customer.name
            );
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.printf(
                    "[%d] ☕️ %s 테이크아웃%n", cups, customer.name
            );
            cups--;
        }

        // notify는 알리는 것이다.
        // 기본적으로 쓰레드는 모두 잠든 상태
        // 그래서 notify를 통해 모두 깨우고 wait을 통해 본인이 잠이 드는 것이다
        // 만약 순서가 바뀐다면 wait으로 인해 잠이 들어버리고 notify로 깨워줄 사람이 없어지는 것이다.
        notifyAll();
        try {
            wait(); // 커피 탔으면 나간다.
        } catch (InterruptedException e) {}
    }

    synchronized public void fill() {
        if (cups > 3) {
            System.out.printf(
                    "[%d] 👌 재고 여유 있음...%n", cups
            );
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.printf(
                    "[%d] ✅ 커피 채워넣음%n", cups
            );

            cups = CUP_MAX;
        }
        notifyAll();

        try {
            wait();
        } catch (InterruptedException e) {}
    }
}
