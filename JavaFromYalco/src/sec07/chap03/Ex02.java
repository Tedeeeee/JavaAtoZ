package src.sec07.chap03;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("A");
        ThreadGroup groupB = new ThreadGroup("B");
        ThreadGroup groupBB = new ThreadGroup(groupB, "BB");
        ThreadGroup groupC = new ThreadGroup("C");

        // 4개의 그룹을 하나씩 실행하고
        for (ThreadGroup tg : new ThreadGroup[] {groupA, groupB, groupBB, groupC}) {
            // 하나의 그룹을 3번씩 실행
            for (int i = 0; i < 3; i++) {
                // 예를 들어 A 그룹이라면
                // 각 그룹당 3번씩 실행하고 no가 1씩 올라간다
                // 3개의 Thread를 만들고 있는 것이 확인이 가능
                new Thread(tg, new PrintThread(tg.getName())).start();
            }
        }

        try (Scanner sc = new Scanner(System.in)){
            while (sc.hasNext()) {
                String line = sc.nextLine();

                if (line.length() == 1) {
                    ThreadGroup[] groups = new ThreadGroup[] {
                            groupA, groupB, groupC
                    };

                    if ("abc".contains(line)) {
                        ThreadGroup group = groups["abc".indexOf(line)];

                        // 그룹의 현황 파악
                        System.out.printf(
                                "%s : %d / %d%n",
                                group.getName(),
                                // 해당 그룹안에 있는 쓰레드의 갯수
                                group.activeCount(),
                                // 내부의 쓰레드들이 멈춰도 active로 카운트
                                // 그 안에서 움직이고 있는 그룹
                                group.activeGroupCount()
                        );
                    }

                    if ("ABC".contains(line)) {
                        // 그룹 일괄 종료
                        ThreadGroup group = groups["ABC".indexOf(line)];
                        // interrupt를 발생시키면 해당 그룹의 Thread들만 interrupt가 발생하며 꺼진다
                        group.interrupt();
                    }
                }

                if (line.equalsIgnoreCase("quit")) break;
            }
        }
    }
}
