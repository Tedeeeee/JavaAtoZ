package src.sec07.chap06.ex01;

public class VolunteerRun implements Runnable{

    private static int lastNo = 0;
    private static int working = 0;

    private int no;
    private Cave cave;

    public VolunteerRun(Cave cave) {
        this.no = lastNo++;
        this.cave = cave;

        System.out.printf(
                "🦺 %d번 지원자 투입 (남은 물 양: %d)%n", no, cave.getWater()
        );
    }

    @Override
    public void run() {
        working++;
        System.out.printf(
                "🪣 %d번 지원자 시작 (현재 %d명 펌핑중, 남은 물 %d)%n",
                no, working, cave.getWater()
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // shutdown은 interruptedException을 발생시킨다.
            // 여기서 return을 해주면 기존에 일을 하던 지원자들도 모두 하던일을 멈추고 나간다.,
            return;
        }

        cave.pump();
        working--;
        System.out.printf(
                "✅ %d번 지원자 완료 (현재 %d명 펌핑중, 남은 물 %d)%n",
                no, working, cave.getWater()
        );
    }
}
