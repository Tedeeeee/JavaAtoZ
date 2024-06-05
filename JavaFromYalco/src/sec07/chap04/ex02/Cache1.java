package src.sec07.chap04.ex02;

public class Cache1 {
    static boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            int i = 0;
            // 컴퓨터가 stop이 true로 변환된 것을 모르고 무한 루프가 진행
            while (!stop) {
                i++;

                // 주석 처리의 차이
                // print 가 되지 않으면 JVM입장에서 굳이 일하던걸 내놓을 필요가 없다
                // 때문에 "쓰레드 종료"라는 문구가 나가지 않고 계속해서 while문이 도는 것이다.
                //System.out.println(i);
            }

            System.out.println("- - - 쓰레드 종료 - - -");
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        stop = true;

        // JVM의 캐시 방식에 따라 멈출 수도 안 멈출 수도 있다
        // - stop으로의 접근이 동기화되지 않았다면
        // - 한 쓰레드가 그 값을 바꾼다고 하더라도 다른 쓰레드는 캐시에 저장된 이전 값을 참조 할 수 없다.
        // - println 메소드는 위 코드에서 캐시를 비우는 이유를 제공한다.
    }
}
