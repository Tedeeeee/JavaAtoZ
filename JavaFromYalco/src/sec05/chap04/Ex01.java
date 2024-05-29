package src.sec05.chap04;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  스트림
 *
 *  연속되는 요소들의 흐름
 *  - 배열, 콜렉션, 파일 등에서 만들어질 수 있다
 */

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> int0To9 = new ArrayList<>(
                Arrays.asList(5, 2, 0, 8, 4, 1, 7, 9, 3, 6)
        );
        // 홀수만 골라내고 정렬하여 "1, 3, 5, ... " 와 같은 문자열로 만들어보자

        List<Integer> odds = new ArrayList<>();

        for (int i : int0To9) {
            if (i % 2 != 0) {
                odds.add(i);
            }
        }

        odds.sort(Integer::compareTo);

        List<String> oddsStrs = new ArrayList<>();
        for (Integer i : odds) {
            oddsStrs.add(String.valueOf(i));
        }

        String oddsStr = String.join(", ", oddsStrs);

        System.out.println(oddsStr);

        // 위의 기나긴 과정을 Stream을 사용하면 굉장히 짧게 만들 수 있다.
        int0To9.stream()
                .filter(i -> i % 2 == 1)
                .sorted(Integer::compareTo)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        /**
         *  정수기를 생각하면 좋다. 필터를 통해 정수된 물만 나오는 것
         *
         *  일련의 데이터를 연속적으로 가공하는데 유용하다
         *  - 내부적으로 수행 -> 중간과정이 밖으로 드러나지 않는다
         *  -- 외부에 변수등이 만들어지지 않는다
         *  - 배열, 콜렉션, I/O 등을 동일한 프로세스로 가공한다
         *  - 함수형 프로그래밍을 위한 다양한 기능들을 제공한다
         *  - 가독성 향상
         *  - 원본을 수정하지 않는다. -> 정렬 등에 영향을 받지 않는다.
         *  이후 배울 멀티 쓰레딩에서 병렬처리가 가능하다
         */

    }
}
