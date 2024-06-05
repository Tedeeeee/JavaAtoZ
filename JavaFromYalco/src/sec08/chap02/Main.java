package src.sec08.chap02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  java.nio.file 패키지
 *  - 자바 7에서 도입되었다.
 *  - 기존의 java.io 패키지 보다 안정적이고 다양한 기능을 가지고 있다
 */
public class Main {

    // Paths 클래스
    // - 파일 시스템 경로를 인스턴스화한 Path 객체를 생성한다
    // - 경로를 보다 편리하고 직관적으로 다루는 기능들을 제공한다

    // 기본적으로 파일, 폴더를 만들 경로를 고정한다
    public static final String CUR_PATH = "src/sec08/chap02/";

    public static void main(String[] args) {
        // 프로젝트 폴더의 경로
        Path path1 = Paths.get("");
        Path path1Abs = path1.toAbsolutePath();

        Path path2 = Paths.get("my_file.txt");
        Path path2Abs = path2.toAbsolutePath();

        // 인자로 들어온 문자열을 각각 내부 폴더로 보낸다.
        Path path3 = Paths.get(CUR_PATH, "sub1", "sub2", "sub3");

        // 두 경로를 통합한다
        Path path4 = path3.resolve(path2);

        // 부모 경로
        Path path5 = path4.getParent();

        // 한 경로에서 다른 경로로의 상대 경로
        Path path6 = path5.relativize(path2);

        // 끝단 파일 / 폴더명
        Path path7 = path4.getFileName();

        // 서브 경로
        Path path8 = path4.subpath(3, 5);

        System.out.println(Files.exists(path2));

        // Path 기준으로 파일이 생성된다

        // 1번째
        try {
            Files.createFile(path2);
        } catch (IOException e) {
            // 파일이 이미 존재하면 예외를 던진다
            System.out.println("파일이 이미 존재한다");
        }
        System.out.println(Files.exists(path2));

        // 2번째
        try {
            Files.createDirectory(
                    Paths.get(CUR_PATH, "myFolder")
            );
        } catch (IOException e) {
            // 폴더가 이미 존재한다.
            System.out.println("폴더가 이미 있다");
        }

        // 3번째
        // 중첩된 폴더 한 번에 생성한다
        try {
            Files.createDirectories(
                    path4.getParent()
            );
            // 폴더들을 미리 만들고 그곳에 파일을 생성한다
            Files.createFile(path4);
        } catch (IOException e) {
            System.out.println("이미 존재한다");
        }

        // Files를 사용해서 파일 쓰기
        // - 용량이 크지 않은 데이터를 쓰는데 적합하다
        // - 덧붙이는 작업이나 대용량 작업은 나중에 다뤄보자

        // write : 파일에 주어진 바이트 배열을 작성
        // - 이미 내용이 있을 경우에 덮어씌운다
        try {
            // getBytes : 문자열로부터, 주어진 인코딩 형식에 따라 바이트 배열로 반환한다.
            Files.write(path4, "안녕하세요".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> lines = Arrays.asList(
                "아기상어 뚜루루뚜루", "귀여운 뚜루루뚜루",
                "바다속 뚜루루뚜루",  "아기상어",
                "",
                "엄마상어 뚜루루뚜루", "어여쁜 뚜루루뚜루",
                "바다속 뚜루루뚜루",  "엄마상어"
        );

        // 문자열의 List를 받아서 줄 별로 작성하기
        try {
            Files.write(path4, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 파일의 내용을 byte배열로 전부 받아오기
        // - 대용량의 파일이라면 부적합한 방법이다.
        byte[] path4Bytes;
        try {
            path4Bytes = Files.readAllBytes(path4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String path4Contents = new String(path4Bytes);
        System.out.println(path4Contents);

        System.out.println("\n- - - - - - -\n");

        // 파일의 내용을 문자열의 리스트로 전부 받아온다.
        // 역시 대용량의 파일의 경우에는 부적합하다
        List<String> path4Read = null;

        try {
            path4Read = Files.readAllLines(path4);
            path4Read.stream()
                    .map(s -> "🎤 " + s)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n- - - - - - -\n");

        // 파일의 내용을 한 줄씩 스트림으로 받아온다
        // 대용량 파일을 읽는데 보다 적합하다
        // 한줄씩만 받아오기 때문에 효율적이다
        // 중단시 스트림을 닫을 필요가 없다 -> try - with - resources 사용
        // 파일이 너무 크다면 제한을 둘 필요가 있다
        try (Stream<String> lineStrm = Files.lines(path4)) {
            lineStrm
                    .map(s -> "🎵 " + s)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 복사하고자 하는 곳의 위치와 거기에 생성할 파일 이름
        Path copied = Paths.get(
                path4.getParent().toString(), "copied.txt"
        );

        // 복사할 내용이 있는 곳과 복사할 파일입력
        try {
            Files.copy(path4, copied);
        } catch (IOException e) { }

        Path moved = Paths.get(
                path4.getParent().getParent().toString(),
                "moved.txt"
        );

        // 파일을 이동하려고 한다.
        try {
            Files.move(path4, moved);
        } catch (IOException e) {
            System.out.println("파일이 이미 존재한다.");
        }

        // 파일을 삭제
        try {
            Files.delete(moved);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
