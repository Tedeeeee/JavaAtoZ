package src.sec07.chap06.ex01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  - Executors & ExecutorService 를 사용
 *  -- concurrent 패키지에서 제공한다
 *
 *  - 많은 쓰레드 작업이 필요하다면 동시에 돌아가는 쓰레드들의 갯수를 제한한다
 *  -- 너무 많은 쓰레드 작업으로 인한 부하 방지
 *
 *  - 그때 그때 쓰레드를 생성/제거하지 않는다
 *  -- 주어진 갯수만큼 쓰레드들을 만든 뒤에 재사용한다
 *
 *  - 개발자가 직업 쓰레드를 생성하고 또 조작할 필요가 없어진다
 *  -- Runnable을 대기열에 추가하면 자리가 나는대로 태워보낸다
 *  -- 쓰레드들을 쓰레드 풀이 자동으로 관리한다
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        // 쓰레드 풀을 관리하는 방법
        ExecutorService es = Executors.newFixedThreadPool(
                // 동시에 일할 수 있는 지원자의 수
                // - 숫자를 변경하면 결과가 조금 달라진다
                5
        );

        Cave cave = new Cave();

        while (cave.getWater() > 20) {
            // execute : Runnable(지원자)을 대기열에 추가한다
            es.execute(new VolunteerRun(cave));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }

        // shutdown : 풀을 닫는다.
        // - 이를 생략하면 프로그램이 끝나지를 않는다
        // - 일단 들어간 지원자는 자리가 날 때까지 기다리다가 일을 한다
        es.shutdown();
        // 닫고 나서 execute 해봐야 이미 닫혀서 소용없다

        // shutdownNow : 풀을 닫고 투입된 지원자 해산
        // - 진행중인 업무 강제 종료는 보장하지 않는다
        // - 각 쓰레드에 InterruptedException을 유발할 뿐이다.
        // - 각 Runnable에서 해당 예외 발생시 종료되도록 처리해주어야 한다
        // - 투입되어 대기 중인 지원자들은 리스트 형태로 반환된다.
//        List<Runnable> waitings = es.shutdownNow();
//        System.out.println(waitings);
    }
}
