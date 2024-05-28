package src.sec05.chap01;

public class Main {
    public static void main(String[] args) {
        Printer printer1 = new Printer() {
            @Override
            public void print() {
                System.out.println("람다식이 존재하지 않았을때 방식");
            }
        };

        Printer printer2 = () -> {
            System.out.println("인자도 반환값도 없는 람다식");
        };

        Printer printer3 = () -> System.out.println("반환값이 없다면(void) {} 생략이 가능하다");
        Printer printer4 = () -> {
            System.out.println("코드가 여러 줄일 때는");
            System.out.println("{ } 가 필요하다");
        };

        for (Printer p : new Printer[]{printer1, printer2, printer3, printer4}) {
            p.print();
        }

        Returner returner1 = () -> 1;
        Returner returner2 = () -> "반환 코드만 있을 시 { }와 return 생략이 가능하다";

        Object returned1 = returner1.returnObj();
        Object returned2 = returner2.returnObj();

        // 구현할 메소드가 단한개의 파라미터를 받기 때문에 파라미터를 적어주어야 한다.
        SingleParam square = (i) -> i * i;
        // 전달할 인자가 한개라면 ( )없이 진행가능
        SingleParam cube = i -> i * i * i;

        DoubleParam add = (a, b) -> a + b;
        DoubleParam multAndPrint = (a, b) -> {
            int result = a * b;
            System.out.printf("%d * %d = %d", a, b, result);
            return result;
        };

        int added = add.func(2, 3);
        int multiplied = multAndPrint.func(2, 3);

        /**
         *  예외 : java의 Comparator는 함수형 인터페이스지만 추상 메소드가 둘(compare, equals)이다.
         *  하지만 사용자가 정의할 부분은 compare 메소드만 있기 때문에
         *  - equals는 이미 object클래스에 있기 때문에 구현의 대상이 되지 않는다
         */
    }

}
