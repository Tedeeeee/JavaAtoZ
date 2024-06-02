package src.sec06.chap04;

import java.io.FileNotFoundException;
import java.util.Random;

/**
 *  Checked 예외 와 UnChecked 예외
 *   - 예외처리 필수 여부
 */
public class Ex01 {
    // RuntimeException과 그의 자손들 : unChecked 예외
    // - 주로 개발자의 실수로 일어나는 예외 ( 실수 안하면 된다 )
    // - 예외처리가 필수가 아니다 ( 하지 않아도 컴파일 가능 )
    public static void maybeException1() {
        // true이면 RuntimeException 발생
        // false면 그냥 지나간다.
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        }
    }

    // 다른 예외들은 checked 예외이다
    // - 해당 메소드 내에서, 또는 호출한 곳에서 예외처리가 필수이다.
    // - 외적 요인으로 발생하는 예외 ( 조심해도 소용없다. 때문에 대비해야한다. )
    public static void maybeException2() throws FileNotFoundException {
        if (new Random().nextBoolean()) {
            throw new FileNotFoundException();
        }
    }

}
