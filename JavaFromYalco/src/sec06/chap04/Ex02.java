package src.sec06.chap04;

import java.util.*;

public class Ex02 {
    // 예외를 던질 가능성이 있지만 스스로 처리하지는 않는 메소드
    public static void registerDutyMonth(String name, int month) throws WrongMonthException {
        if (month < 1 || month > 12) {
            throw new WrongMonthException("하... 직원 교육 부탁드립니다. 월이 틀렸어요");
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
    }

    /**
     *  일단 자기 선에서도 처리하고 외부로도 던지는 메소드
     *   - 필요한 일은 하되, 정상적으로 진행된 것은 아님을 호출부에 알리기 위함이다.
     *   - 예외를 양쪽에서 처리해줄 필요가 있을 때
     */
    public static void registerDutyMonthSafer(String name, int month) throws WrongMonthException {
        try {
            if (month < 1 || month > 12) {
                throw new WrongMonthException(
                        "일단 저희가 아무 달에 배정하겠습니다"
                );
            }
            System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
        } catch (WrongMonthException we) {
            System.out.printf(
                    "%s씨 %d월 담당으로 배정되셨어요.%n",
                    name, new Random().nextInt(1, 12 + 1)
            );
            throw we;
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> dutyRegMap = new HashMap<>();
        dutyRegMap.put("정핫훈", 7);
        dutyRegMap.put("김돌준", 13);

        dutyRegMap.forEach((name, month) -> {
            // 실행부에서, 혹은 또 이를 호출한 외부에서 처리해주어야 한다.
            try {
                registerDutyMonth(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace();
                System.out.printf("%s씨 에어팟 빼봐요.%n", name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        dutyRegMap.forEach((name, month) -> {
            // 메소드 내부에서 잘못된 달에 대한 문제 처리하지만
            // throw 하여 다시 에러를 던진다.
            // 그래서 추가로 또 catch를 해주어야 한다.
            // 이렇게 일은 일대로 일단 하고 주의를 줘야 하는 상황을 만드는 것이다.
            try {
                registerDutyMonthSafer(name, month);
            } catch (WrongMonthException we) {
                we.printStackTrace();
                System.out.println("내가...왜 또 불렀는지 이제 아시죠?");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
