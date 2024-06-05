package src.sec08.chap04;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *  InputStream & OutputStream : 바이트 기반의 스트림이다.
 *  문자 기반의 스트림은 Reader 와 Writer가 담당한다
 *   - 문자 인코딩을 지원한다
 *   - 문자열을 줄 단위로 처리한다
 *   - 바이트 스트림과 문자 스트림 간의 변화
 *
 *   하위 클래스
 *   - Reader
 *    -> FileReader
 *    -> InputStreamReader
 *    -> BufferedReader
 *    -> StringReader
 *   - Writer
 *    -> FileWriter
 *    -> OutputStreamWriter
 *    -> BufferedWriter
 *    -> StringWriter
 */

public class Ex01 {
    public static final String SONG_PATH = "src/sec08/chap04/beatles.txt";

    public static void main(String[] args) {

        // Buffered..를 사용하고 안하고의 차이가 보인다
        var frw = measureTime(Ex01::fileReaderWriterEx);
        var brw = measureTime(Ex01::bufferedReaderWriterEx);


    }

    public static void fileReaderWriterEx () {
        Charset charset = StandardCharsets.UTF_8;

        // FileReader & FileWriter
        // - 파일에 텍스트를 입출력하는 기본 클래스이다
        try (
                FileReader fr = new FileReader(
                        SONG_PATH, charset
                );

                FileWriter fw = new FileWriter(
                        SONG_PATH.replace("beatles", "beatles_1")
                        , charset
                )
        ) {
            int c;
            // 한글자씩 불려오고 출력 후 사용하기 때문에 비효율적이다. 곧 다룰 Buffered를 사용한다
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
                fw.write(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bufferedReaderWriterEx () {
        Charset charset = StandardCharsets.UTF_8;

        // BufferedReader & BufferedWriter
        // 파일 텍스트 입출력에 버퍼를 사용한다
        try (
                FileReader fr = new FileReader(
                        SONG_PATH, charset
                );

                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(
                        SONG_PATH.replace("beatles", "beatles_2")
                        , charset
                );

                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String line;
            // 한 줄씩 바구니에 버퍼링해서 읽어온다.
            // - File... 만 사용하는 것보다는 효율적이다.
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String measureTime(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();

        return String.valueOf("%d 나노초".formatted(endTime - startTime));
    }

    public static void ioStreamReaderWriterEx () {
        Charset charset = StandardCharsets.UTF_8;

        // InputStreamReader & OutputStreamWriter
        // 각종 Input/Output Stream을 Reader/Writer로 바꿔준다
        try (
                // 기본적으로 8192바이트짜리 트럭에 실어온다
                FileInputStream fis = new FileInputStream(SONG_PATH)

                )
    }
}
