package src.sec06.chap05;

import java.util.Random;

public class SuicideSquad implements AutoCloseable {
    public void doSecretTask() throws OpFailException {
        System.out.println("🧨 작전 시작");
        if (!(new Random().nextBoolean())) {
            throw new OpFailException();
        };
        System.out.println("🔫 비밀 작전 수행");
    }

    @Override
    public void close() throws Exception {
        System.out.println("💣 전원 폭사\n- - - - -");
    }
}
