package src.sec07.chap02;

public class Ex01 {
    public static void main(String[] args) {
        Thread tarzanThread = new Thread(new TarzanRun(10));

        tarzanThread.setName("타잔송");

        tarzanThread.start();
    }
}
