package src.sec07.chap03;

/**
 *  쓰레드 그룹
 *  - 연관된 쓰레드들을 그룹으로 묶기 위해 사용된다
 *  - 쓰레드 그룹이 다른 쓰레드 그룹에 포함될 수 있다
 *  - 쓰레드를 일괄적으로 다루거나 보안상 분리하기 위해 사용한다.
 */
public class Ex01 {

    public static void main(String[] args) {
        Thread thr1 = new Thread(() -> {});

        // 따로 그룹을 지정해주지 않은 쓰레드
        // - main쓰레드 그룹에 속한다
        ThreadGroup mainThrGroup = thr1.getThreadGroup();
        String mainThrGroupName = mainThrGroup.getName();

        // 쓰레드 그룹을 직접적으로 생성
        ThreadGroup threadGroup1 = new ThreadGroup("TG_1");
        String thrGroup1Name = threadGroup1.getName();

        // 그룹에 속한 쓰레드를 만드는 생성자
        // Thread의 인자 맨 앞에 그룹의 이름을 붙여준다
        Thread thr2 = new Thread(threadGroup1, () -> {});
        String thr2GroupName = thr2.getThreadGroup().getName();

        // 또 다른 쓰레드 그룹에 속한 쓰레드 그룹 만들기
        // 즉, 2번째로 만든 쓰레드 그룹을 그룹 1번안에 넣어놓겠다는 이야기
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "TG_2");
        String thrGroup2ParentName = threadGroup2.getParent().getName();
    }
}
