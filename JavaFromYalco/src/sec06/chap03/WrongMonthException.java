package src.sec06.chap03;

/**
 *  사용자 정의 예외 만들기
 *   - 예외의 타입으로 어떤 예외인지 전달한다
 *   - 예외에 추가적 기능을 담을 때
 */
public class WrongMonthException extends RuntimeException{
    public WrongMonthException(int month) {
        // 최고 조상인 Throwable의 생성자를 확인한다
        // - detailMessage에 값을 넣는 오버로드
        super(
                ("당신이 사는 세계에는 %d월이 있나 보군요." +
                        "멀티버스 여행이 가능해진다면" +
                        "저도 꼭 %d월을 살아 보고 싶습니다.")
                        .formatted(month, month)
        );
    }
}
