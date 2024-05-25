package src.sec03.chap03.ex02;

public class Main {

    /**
     *  생성시 오른쪽에 < >을 꼭 붙여주어야 하는 이유
     *
     *  붙이지 않는다면 생성하는 인스턴스의 자료형을 체크하지 않는다. 때문에 자료형을 맞춰도 컴파일러가 걸러내지 못한다.
     *  < >을 붙이면 타입추론을 하여 자료형에 맞는 제네릭을 채워넣는다. 의도한 바에 맞지 않은 자료형을 사용했을때 컴파일 오류를 발생시킨다
     */

    public static void main(String[] args) {
        // 선언시 아래와 같이 자료형에 각 타입변수의 자료형을 명시해야 한다
        // - 제네릭에는 원시값이 아닌 참조값이 들어가야한다
        // - wrapper 클래스의 또 다른 존재의 이유
        Pocket<Double, Double, Double> size3d1 =
                new Pocket<>(123.45, 234.56, 345.67);

        Pocket<Double, Double, Double> size3d2 =
                new Pocket<>(123.45, 234.56, 345.67);

        double width = size3d1.getFieldA();
        double height = size3d1.getFieldB();
        double depth = size3d1.getFieldC();

        Pocket<String, Integer, Boolean> person =
                new Pocket<>("홍길동", 20, false);

        // 제네릭 클래스는 배열로 생성 시 new 연산자로 초기화하는 것이 필수이다.
        Pocket<String, Integer, Boolean>[] peoples = new Pocket[]{
                new Pocket<>("홍길동", 20, false),
                new Pocket<>("전우치", 30, true),
                new Pocket<>("임꺽정", 27, true)
        };
    }
}
