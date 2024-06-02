package src.sec06.chap05;

public class Ex02 {
    public static void dirtyOperation() {
        try (SuicideSquad sc = new SuicideSquad()) {
            sc.doSecretTask();
        } catch (OpFailException e) {
            // 예외 상황은 아만다 윌러가 책임진다
            System.out.println(e.getMessage() +"로 인해 🗑️ 증거 인멸\n- - - - -");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // close가 실행되는 시점은 Exception이 발생하기 전이다.
    // 때문에 exception의 내용인 작전 실패보다 전원 폭사가 먼저 나오는 것이다.
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "번째 작전!");
            dirtyOperation();
        }
    }
}
