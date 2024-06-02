package src.sec06.chap04;

/**
 *  예외를 메소드 외부로 떠넘기기
 *   - 이런 예외가 발생할 수 있는데 책임을 지지않는다. 시킨 사람이 처리
 */
public class WrongMonthException extends Exception{
    // Exception이 처리해야지 왜 내가 처리함?
    public WrongMonthException(String message) {
        super(message);
    }

    public WrongMonthException(String message, Throwable cause) {
        super(message, cause);
    }
}
