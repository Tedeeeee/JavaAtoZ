package src.sec06.chap01;

import java.nio.file.Paths;

/**
 *  자바 프로그램의 오류 error
 *  - 컴파일 오류 : 컴파일 과정에서 잡히는 오류
 *    - 문법 오류, 자료형 오류, 잘못된 식별자 등등
 *  - 런타임 오류 : 아래의 두 종류로 구분된다
 *    에러(error)와 예외(exception)란?
 *    - 에러 = 해결 불가능한 문제
 *      = 무한 루프, 메모리 한도 초과, 스택오버플로우 등등...
 *      일반적인 시스템 레벨의 문제
 *
 *    - 예외 = 해결이 가능한 문제
 *      = 읽어오려는 파일이 없거나 배열의 길이가 부족함으로 발생한 문제
 */
public class Main {
    /**
     * Throwable
     * - Error
     * VirtualMachineError
     * : OutOfMemoryError
     * : StackOverflowError
     * - Exception
     * RuntimeException
     * : IndexOutOfBoundException
     * : NullPointerException
     * : ClassCastException
     * IOException
     * : FileNotFoundExceptino
     * <p>
     * <p>
     * 예외의 두 종류
     * Unchecked Exception
     * - RuntimeException 의 하위 클래스
     * : 개발자의 실수에 의해 발생할 수 있는 예외
     * : 실수를 안한다면 꼭 처리를 할 필요가 없음
     * checked Exception
     * - 기타 예외
     * : 주로 외적 요인으로 발생
     * : 발생 가능한 부분에는 반드시 예외처리해야한다.
     */
    public static void main(String[] args) {
        // try ~ catch
        // 예외가 발생할 수 있는 부분에 대비해서 프로그램 종료를 대비한다
        int[] ints = {1, 2, 3};

        // getMessage : 예외에 대한 간략 정보 문자열ㄹ 반환한다.
        // printStackTrace : 에러의 종류, 발생위치, 전반 단계 출력
        try {
            // 예외가 발생할 수도 있는 코드를 try 블록에 작성한다
            System.out.println(ints[3]);
        } catch (Exception e) {
            String errMsg = e.getMessage();
            e.printStackTrace();
        }
        System.out.println("예외를 try 문으로 감싸면 예외를 발생시켜 알리고 다음 코드 실행");

        try {
            System.out.println(((String) null).length());
        } catch (Exception e) {
            String errMsg = e.getMessage();
            e.printStackTrace();
        }
        System.out.println("예외를 try 문으로 감쌌을때 2번째 버전");

    }
}
