package src.sec06.chap06;

import src.sec05.chap05.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        // Stream의 형태
        var numFromOpt = IntStream.range(0, 100)
                //.parallel() // 병렬로 실행한다.

                .filter(i -> i % 2 == 1)
                //.filter(i -> i > 100)

                // 여기 밑의 메소드들이 모두 Optional을 반환하는 메소드이다.

                // 첫번째 요소를 반환한다.
                //.findFirst() // 항상 순서상 첫번째 것을 반환한다.
                //.findAny() // 병렬 작업시 먼저 나오는 것을 반환한다.
                // 병렬로 작업하면 findAny가 효율적이다.

                //.max()
                //.min()

                // 평균값을 Double로 반환한다
                //.average()

                .reduce((prev, curr) -> prev + curr)

                .orElse(-1); // Optional이 반환되기 때문에
                // 혹은 기타 Optional의 인스턴스 메소드를 사용한다.

        String[] names = {
                "강백호", "서태웅", "채치수", "송태섭", "정대만",
                "윤대협", "변덕규", "황태산", "안영수", "허태환",
                "이정환", "전호장", "신준섭", "고민구", "홍익현",
                "정우성", "신현철", "이명헌", "최동오", "정성구"
        };

        Stream<String> nameStream = Arrays.stream(names);

        Random random = new Random();
        random.setSeed(4);

        List<Person> people = nameStream
                .map(name -> new Person(
                        name,
                        random.nextInt(18, 35),
                        random.nextDouble(160, 190),
                        random.nextBoolean()
                ))
                .sorted()
                .toList();

        Person personFromOpt = people.stream()
                .filter(p -> !p.isMarried() && p.getAge() < 20 && p.getHeight() > 189)

                .findFirst()

                //.max(Comparator.comparingDouble(Person::getHeight))
                //.min(Comparator.comparingInt(Person::getAge))

                .orElse(new Person("엄친아", 19, 189.9, false));
    }
}
