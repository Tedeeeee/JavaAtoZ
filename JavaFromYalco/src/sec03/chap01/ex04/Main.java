package src.sec03.chap01.ex04;

public class Main {
    public static void main(String[] args) {
        NotCloneable notCloneable = new NotCloneable(
                "클릭들 1", 1,
                new int[]{1, 2, 3},
                new Click(12, 34),
                new Click[] {new Click(12, 34), new Click(56, 78)}
        );

        NotCloneable clone1 = null;

        // cloneable을 구현하지 않은 notCloneable 클래스는 clone이 작동하지 않는다.
        // 작동하는 것 처럼 보이게 하려면 생성자를 넣어주는 것 처럼 일일이 작성해주어야 한다.
        try {
            clone1 = (NotCloneable) notCloneable.clone();
        } catch (CloneNotSupportedException e) {
            System.out.printf("⚠️ 복제중 오류 발생 : %s%n", notCloneable);
        }

        // 가볍게 clone하기 위해 shallowCopied
        ShallowCopied shallowCopied = new ShallowCopied(
                "클릭들 1", 1,
                new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78) }
        );

        ShallowCopied clone2 = null;

        try {
            clone2 = (ShallowCopied) shallowCopied.clone();
        } catch (CloneNotSupportedException e) {
            //  오류가 나지 않으므로 실행되지 않음
            System.out.printf("⚠️ 복제중 오류 발생 : %s%n", shallowCopied);
        }

        shallowCopied.title = "제목 바뀐다";
        shallowCopied.no = 2;
        //  ⚠️ 참조 타입들은 완전히 복사되지 않음 (주소만 복사)
        shallowCopied.numbers[0] = 0;
        shallowCopied.click.x = 99;
        shallowCopied.clicks[0].x = 99;

        DeepCopied deepCopied = new DeepCopied(
                "클릭들 1", 1, new int[] {1, 2, 3},
                new Click(12, 34),
                new Click[] { new Click(12, 34), new Click(56, 78) }
        );

        DeepCopied clone3 = null;
        try {
            clone3 = (DeepCopied) deepCopied.clone();
        } catch (CloneNotSupportedException e) {
            //  오류가 나지 않으므로 실행되지 않음
            System.out.printf("⚠️ 복제중 오류 발생 : %s%n", deepCopied);
        }

        deepCopied.title = "제목 바뀜";
        deepCopied.no = 2;
        deepCopied.numbers[0] = 0;
        deepCopied.click.x = 99;
        deepCopied.clicks[0].x = 99;
    }
}
