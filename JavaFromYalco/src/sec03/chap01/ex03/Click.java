package src.sec03.chap01.ex03;

public class Click {
    int x;
    int y;
    int timestamp;

    public Click(int x, int y, int timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

    /**
     *  hash값이 같다고 주소값이 같다는 것이 아니다.
     *
     *  hashCode는 객체의 해시 코드 값을 반환한다. 단지 객체를 해시 테이블에서 효율적으로 찾기 위한 코드
     *  equals와 굉장히 연관이 있는데 equals 즉, 값이 같다면 hashcode도 같아야 한다는 것이다.
     *  하지만 hashCode가 같다고 equals가 true를 반환하지 않아도 된다.
     *  왜냐하면 hash가 충돌할 수 있기 때문이다.
     *  그래서 hash가 같으면 그 이후에 equals가 시작되고 값을 정확하게 찾기 시작한다.
     */

//    @Override
//    public int hashCode() {
//        return x * 100_000 + y;
//    }
}
