package src.sec06.chap04;

import java.util.HashMap;
import java.util.Map;

/**
 *  연결된 예외 chained exception
 *   - 특정 예외가 발생할 때 이를 원인으로 하는 다른 예외를 던진다.
 */
public class Ex04 {
    public static void chooseDutyMonth(String name, int index) throws WrongMonthException {
        int[] availables = {1, 3, 4, 7, 9, 12};

        try {
            int month = availables[index - 1];
            System.out.printf("%s씨 %d월 담당으로 배정되셨습니다", name, month);
        } catch (ArrayIndexOutOfBoundsException ae) {
            WrongMonthException we = new WrongMonthException(
                    "%d번은 없습니다.".formatted(index)

            );

            // 예외의 원인이 되는 예외를 지정한다
            // 다만 이를 수행하는 생성자가 없을 경우에 해당한다
            we.initCause(ae);
            // 이 예외는 cause를 입력받는 생성자를 지정해놓았다.

            // 다른 종류의 예외가 발생해도 이 예외의 원인으로 등록해서
            // 통일된 타입의 예외로 반환도 가능하다.
            throw we;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> dutyRegMap = new HashMap<>();
        dutyRegMap.put("정핫훈", 3);
        dutyRegMap.put("김돌준", 8);

        dutyRegMap.forEach((name, month) -> {
            // 실행부에서, 혹은 또 이를 호출한 외부에서 처리해주어야 한다.
            try {
                chooseDutyMonth(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace(); // 로그에서 Caused By 항목 확인 해 볼수 있다
                System.out.printf("%s씨, 자꾸 왜 그러는거야%n", name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
