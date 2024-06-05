package src.sec07.chap05.ex01;

import java.util.Arrays;

/**
 *  Object의 쓰레드 관련 메소드
 *  - wait : 동기화 메소드 사용 중 자신의 일을 멈춘다
 *   -- 다른 쓰레드가 사용할 수 있도록 양보
 *   -- 다음 분 먼저 사용하세요
 *  - notify : 일을 멈춘 상태의 쓰레드에게 자리가 비었음을 통보
 *   -- 대기열의 쓰레드 중 하나에게 통보
 *    -> 상황에 따라서는 무한대기 상태가 될 수 있다.
 *   -- 다 사용했습니다.
 *  - notifyAll : 대기중인 모든 쓰레드에게 통보
 *   -- 여러분, 여기 이제 비었습니다
 *    -> notify 보다 일반적으로 널리 사용한다.
 */

public class Main {
    public static void main(String[] args) {
        PhoneBooth phoneBooth = new PhoneBooth();

        Arrays.stream("김병장,이상병,박일병,최이병".split(","))
                .forEach(s -> new Thread(
                        new SoldierRun(s, phoneBooth)
                ).start());
    }
}
