package src.sec07.chap04.ex02;

/**
 * Cache1에서는 따로 작업 중인 내용을 화면에 나타내거나 따로 사용하지 않으면 계속해서 내용을 가지고 있었다.
 * 그래서 Thread를 sleep 시켜도 문제가 발생할 수 있다
 */
public class Cache2 {

    // 동기화 사용
    volatile static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;

                // System.out.println이 따로 존재하지 않아도 멈추는 것을 확인 할 수 있다.
            }

            System.out.println("- - - 쓰레드 종료 - - -");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        stop = true;

        /**
         *  volatile 연산자
         *   - 변수의 값이 변경 될 때마다 메모리에 업데이트
         *   - 멀티쓰레딩 환경에서 캐싱에 의한 문제를 방지한다
         *   - 동기화하고는 조금 다르다. 값 변경만 바로 확인 시켜주는 것이다.
         */

    }

}
