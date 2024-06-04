package src.sec07.chap03;

/**
 *  데몬 쓰레드
 *  - 다른 쓰레드의 작업을 보조하는 역할이다
 *  - 주 쓰레드의 작업이 끝나면 자동으로 종료된다
 */
public class Ex03 {
    public static void main(String[] args) {
        Runnable rythmRun = () -> {
            int index = 0;
            String rythm = "쿵쿵짝";

            while (true) {
                System.out.print(rythm.charAt(index++) + " ");
                index %= rythm.length();

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread SingThread = new Thread(() -> {
            String[] lines = new String[] {
                    "푸른하늘 은하수", "하얀 쪽배엔",
                    "계수나무 한나무", "토끼 세마리",
                    "한마리는 구워먹고", "한마리는 튀겨먹고",
                    "한마리는 도망간다", "서쪽나라로"
            };

            Thread rythmThread = new Thread(rythmRun);

            // 리듬 쓰레드를 본 노래 쓰레드의 데몬으로 지정한다
            // - 이 부분이 없으면 노래가 끝나도 리듬이 멈추지 않는다.
            rythmThread.setDaemon(true);

            rythmThread.start();

            for (int i = 0; i < lines.length; i++) {
                System.out.println("\n" + lines[i]);

                try {
                    Thread.sleep(1800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        SingThread.start();
    }
}
