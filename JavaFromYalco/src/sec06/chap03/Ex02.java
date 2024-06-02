package src.sec06.chap03;

import java.io.FileNotFoundException;

public class Ex02 {
    public static void registerDutyMonth(String name, int month) {
        if (month < 1 || month > 12) {
            throw new IndexOutOfBoundsException(
                    "우리 %s씨는 1년에 몇 달이 있는지 아직 못 배웠나봐?"
                            .formatted(name)
            );
        }
        System.out.printf("%s씨 %d월 담당으로 배정되셨어요.%n", name, month);
    }

    public static void openMyFile(String fileName) {
        if (fileName.contains("야구동영상")) {
            try {
                throw new FileNotFoundException(
                        "제 컴퓨터엔 그런 파일이 없어요"
                );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("인강 프로그램을 실행합니다...");
            }
            return;
        }
        System.out.printf("%s 파일 열람%n", fileName);
    }

    public static void main(String[] args) {
        // try문으로 감싸지 않은 코드이다.
        registerDutyMonth("정핫훈", 7);
        // - 다음 코드들이 실행되려면 주석 처리를 해야한다
        // registerDutyMonth("김돌준", 13);

        openMyFile("잘나온얼굴.png");
        openMyFile("야구동영상.avi");
    }

}
