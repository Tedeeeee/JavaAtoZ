package src.sec05.chap01;

/**
 *  람다식 형태로 익명 클래스가 만들어질 수 있는 인터페이스
 *   - 조건 : 추상 메소드가 하나만 있어야 한다
 *      - 람다식과 1:1로 대응될 수 있어야한다
 *      - @FuntionalInterface로 강제한다
 *      - 클래스 메소드와 default 메소드는 여러개 있을 수 있다
 *      - 예외는 존재한다.
 */

@FunctionalInterface
public interface Printer {
    void print();
}
