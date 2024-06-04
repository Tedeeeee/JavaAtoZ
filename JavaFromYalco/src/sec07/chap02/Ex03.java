package src.sec07.chap02;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Thread tarzanSong = new Thread(new TarzanRun(10));
        tarzanSong
                //.run(); // 이건 같은 쓰레드이기 때문에 순서가 보장
                .start();

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();

                // run을 사용했을때는 타잔의 run이 종료되어야 사용가능
                // start를 사용하면 입력을 받는 것은 사용 가능
                if (line.equalsIgnoreCase("check")) {
                    System.out.println("아직 안 끝났니?");
                    System.out.println(
                            // isAlive는 쓰레드의 진행 여부를 확인
                            tarzanSong.isAlive() ? "ㅇㅇ" : "끝났어"
                    );
                }

                if (line.equalsIgnoreCase("enjoy")) {
                    System.out.println("감상할 가치가 있는 노래이다.");

                    // 해당 쓰레드의 차로로 들어가서 (join) - 비유적 표현
                    // 쓰레드의 작업이 다 끝날때까지 기다린다
                    // 즉, join을 사용하면 메소드가 blocking 상태로 변경된다는 것이다.
                    // catch 블록 요구된다.
                    tarzanSong.join();
                }

                if (line.equalsIgnoreCase("stop")) {

                    System.out.println("아 제발 좀 닥쳐봐!");

                    //  💡 해당 쓰레드의 run에 InterruptedException 발생시킴
                    //  - sleep 등에 의해 정지 상태에 있을 때
                    //    - sleep 메소드가 해당 예외를 던지는 이유
                    //  - 강제하는 것이 아니라 메시지를 던지는 것
                    //    - 해당 쓰레드에서 받아주어야 함
                    tarzanSong.interrupt();

                    //  ⭐️ 과거에는 쓰레드를 강제종료하는 stop을 사용했음
                    //  - 위험했기 때문에 deprecated
                    //    - 데이터 오염, 리소스 누수 등
                    //  - suspend, resume 등도 마찬가지
                }

                if (line.equalsIgnoreCase("quit")) break;
                System.out.println(line);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
