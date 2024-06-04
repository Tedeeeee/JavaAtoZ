package src.sec07.chap04.ex01;

public class CustomRun implements Runnable{
    String name;
    ATM atmToUse;
    int needed;

    public CustomRun(String name, ATM atmToUse, int needed) {
        this.name = name;
        this.atmToUse = atmToUse;
        this.needed = needed;
    }

    @Override
    public void run() {
        while (atmToUse.getBalance() > needed) {
            atmToUse.withdraw(name, needed);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
