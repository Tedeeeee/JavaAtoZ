package src.sec07.chap01;

/**
 *  쓰레드 만드는 2가지의 방법
 *  1. Thread 클래스 상속
 *  2. Runnable 인터페이스 구현
 *   - 인터페이스의 유연함으로 Thread보다 많이 사용
 */
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread1(); // Thread를 상속한 클래스
        Thread thread2 = new Thread(new MyRunnable()); // Runnable을 받은 클래스를 쓰레드

        // 익명클래스로도 제작 가능
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.print(3);
                }
            }
        });

        // 해당 쓰레드에 지정된 run메소드를 현제 메인 쓰레드에서 실행
        // 멀티 쓰레드의 사용 의미가 없다
//        thread1.run();
//        thread2.run();
//        thread3.run();

        // 각각의 메소드를 새로운 쓰레드 생성을 통해 동시에 진행
        // 멀티로 진행되기 때문에 결과는 계속해서 다르다.
        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 20; i++) {
            System.out.print('M');
        }

        /**
         *  Thread의 정적 메소드
         *  주어진 밀리초 동안 해당 쓰레드를 멈춘다
         *  sleep은 예외를 발생시키기 때문에 예외를 던져주어야 한다.
         */

    }
}
