package src.sec07.chap02;

public class Ex02 {
    public static void main(String[] args) {
        Thread thr0 = new Thread(new PrintThrNoRun(0));
        Thread thr1 = new Thread(new PrintThrNoRun(1));
        Thread thr2 = new Thread(new PrintThrNoRun(2));

        // 쓰레드의 우선순위(priority) 정하기
        //  - 기본적으로는 같은 우선권을 가지고 있다.
        //      - 메인에서 상속받아 기본으로 5

        thr0.setPriority(Thread.MIN_PRIORITY);
        thr1.setPriority(Thread.NORM_PRIORITY);
        thr2.setPriority(Thread.MAX_PRIORITY);

//        thr0.setPriority(Thread.MAX_PRIORITY);
//        thr1.setPriority(Thread.NORM_PRIORITY);
//        thr2.setPriority(Thread.MIN_PRIORITY);

        // JVM에게 힌트만 줄 뿐 실제로 컨트롤 하는 것은 OS가 한다
        // - 우선순위를 주긴 하더라도 OS가 무시하면 어쩔수 없다
        //thr0.start();
        //thr1.start();
        //thr2.start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.print(3);

                for (int j = 0; j < Integer.MAX_VALUE; j++) {}

                // 만약 해당 쓰레드가 같은 우선순위일 시에 다른 쓰레드에 양보한다.
                Thread.yield();
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            System.out.print('M');
            for (int j = 0; j < Integer.MAX_VALUE; j++) {}
        }

        // yield 역시 결국 힌트만 줄 뿐 결정은 또 OS가 한다.

    }
}
