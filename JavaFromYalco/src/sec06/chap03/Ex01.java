package src.sec06.chap03;

/**
 *  예외 던지기 throw
 *   - 컴퓨터가 문제라고 인식하지 못하는 상황에서 인위적으로 예외가 발생
 */

public class Ex01 {
    public static void main(String[] args) {

        // 예외는 오류가 던져지면 그 아래의 코드는 작성 할 수 없다.
        throw new RuntimeException();

        // 메세지를 특성하여 던진다
        // throw new RuntimeException("뭔가 잘못됐어요");

        // 원인이 되는 다른 예외들을 명시하여 던지기
        //throw new RuntimeException("얘네 때문이다",
        //        new IOException(
        //                new NullPointerException()
        //        )
        //);
    }
}
