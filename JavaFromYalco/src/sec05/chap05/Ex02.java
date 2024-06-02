package src.sec05.chap05;

import java.util.*;
import java.util.stream.*;

public class Ex02 {
    public static void main(String[] args) {
        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구 ", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        // 균일한 결과를 위해 지정된 시드값
        random.setSeed(4);
        List<Person> people = nameStream
                .map(name -> new Person(
                        name, random.nextInt(18, 35), random.nextDouble(160, 190), random.nextBoolean()
                ))
                //.sorted()
                .sorted((p1, p2) -> p1.getHeight() > p2.getHeight() ? 1 : -1)
                //.sorted((p1, p2) -> Boolean.compare(p1.isMarried(), p2.isMarried()))
                .toList();

        // collect, Collectors의 기능들
        // - joining도 이들 중 하나이다.
        // 간단하게 말하자면 stream을 통해 정렬한 데이터를 어떤 방식으로 묶어서 내보낼지 정하는 것이다.
        // - 메소드에 따라 자료형이 달라지기 때문에 var를 사용
        var peopleLastNameSet = people.stream()
                .map(p -> p.getName().charAt(0))

                //  💡 아래 중 원하는 컬렉션으로 택일
                //.collect(Collectors.toList());
                //.collect(Collectors.toSet());
                //.collect(Collectors.toCollection(ArrayList::new));
                //.collect(Collectors.toCollection(LinkedList::new));
                .collect(Collectors.toCollection(TreeSet::new));

        // Map 형태로 정렬된 것은 <기준 값, 기준값에 따라 모인 사람>
        Map<String, Integer> nameAgeMap = people.stream()
                // 정렬은 해시맵이 될 스트림의 정렬로써 의미 없은 작업이다
                .sorted((p1, p2) -> p1.getAge() > p2.getAge() ? 1 : -1)
                .collect(Collectors.toMap(Person::getName, Person::getAge));

        // 결혼 한 사람과 안 한 사람 끼리 묶어 놓기
        Map<Boolean, List<Person>> peopleHMapByMarried = people.stream()
                .collect(Collectors.groupingBy(Person::isMarried));

        List<Person> marrieds = peopleHMapByMarried.get(true);

        Map<Integer, List<Person>> peopleHMapByHeight = people.stream()
                .collect(Collectors.groupingBy(
                        p -> ((int) p.getHeight() / 10) * 10)
                );

        List<Person> over180s = peopleHMapByHeight.get(180);

        Map<Character, List<Integer>> intHMapOddEven = IntStream.range(0 , 10).boxed()
                .collect(Collectors.groupingBy(
                        i -> i % 2 == 1 ? '홀' : '짝'
                ));

        List<Integer> odds = intHMapOddEven.get('홀');

        // 수의 통계를 인스턴스 형태로 갖는 클래스
        IntSummaryStatistics ageStats = people.stream()
                .map(Person::getAge)
                .collect(Collectors.summarizingInt(Integer::intValue));

        DoubleSummaryStatistics heightStats = people.stream()
                .map(Person::getHeight)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
    }
}
