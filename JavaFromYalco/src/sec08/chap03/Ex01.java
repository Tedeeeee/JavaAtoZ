package src.sec08.chap03;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 *  InputStream, OutputStream 클래스
 *  - 데이터의 입력과 출력을 다루는 클래스
 *    -> 파일 쓰고 읽기, 네트워크 통신, 타 프로그램과의 소통에 사용된다
 *  - 데이터를 한 쪽에서 다른 쪽으로 전달하는 것을 흐름(Stream)으로 본다
 *   -> 두 물탱크 간에 물을 보내거나 받아오는 것 처럼
 *  - 이번에 배우는 클래스들의 조상
 *   -> FileInputStream, BufferedInputStream 등등...
 */
public class Ex01 {

    public static final String SONG_PATH = "src/sec08/chap03/beatles.txt";

    public static void main(String[] args) {
        //fileInputStrmEx1();
        //fileInputStrmEx2();
        //fileInputStrmEx3();
        //bufferedInputEx();

        /**
         *  결과만 보면 fileInput3이랑 BufferedInputStream과의 차이가 별로 없어보인다.
         *  때문에 소요시간을 비교해봐야 한다.
         */

        // 1바이트씩 read해서 가져오기 ( 한글 지원 X )
        String fis1 = measureTime(Ex01::fileInputStrmEx1);
        // 바이트 단위 -> 문자열 단위
        String fis2 = measureTime(Ex01::fileInputStrmEx2);
        // buffer를 통해 한번에 가져올 단위 상승
        String fis3 = measureTime(Ex01::fileInputStrmEx3);
        // 내부 버퍼를 사용해서 가져오기 때문에 비어있다면 비어있는대로 가져오기
        String bis = measureTime(Ex01::bufferedInputEx);


    }

    private static String measureTime(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return String.valueOf("%d 나노초".formatted(endTime - startTime));
    }

    public static void fileInputStrmEx1 () {
        // FileInputStream
        // - InputStream으로부터 상속받는다
        // - 파일로부터 데이터를 받아오는데 사용한다
        // - try-with-resource로 스트림 열고 닫는다
        try (FileInputStream fis = new FileInputStream(SONG_PATH)) {
            int readByte;

            // read : 파일로부터 1바이트씩 읽어온다 - 성능 저하
            // - 더 읽어올 것이 없을 때 -1 반환한다.
            while ((readByte = fis.read()) != -1) {
                char readChar = (char) readByte;

                // 한 글자씩 가져온다.
                System.out.print(readChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileInputStrmEx2 () {
        // 인코딩 설정 - UTF-8
        Charset charset = StandardCharsets.UTF_8;

        try (
                FileInputStream fis = new FileInputStream(SONG_PATH);

                // InputStreamReader : 바이트 스트림을 문자열 스트림으로 만든다
                // - 인코딩 적용 등에 사용된다
                // 중요한 것은 FileInputStream에 넣는 것은 따로이고 그것을 한글화하여 사용할 수 있게 하는 것 또한 따로라는 것이다.
                InputStreamReader isr = new InputStreamReader(fis, charset);
        ) {
            int readByte;
            while ((readByte = isr.read()) != -1) {
                char readChar = (char) readByte;
                System.out.print(readChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileInputStrmEx3 () {
        // 버퍼를 사용한다
        // - 하나씩 손에 들고 오는게 아니라 바구니에 담아온다
        // - 1바이트씩 받아올 때(read)보다는 효율적이다.
        byte[] buffer = new byte[1024]; // 1024Byte가 담기는 바구니를 생성

        Charset charset = StandardCharsets.UTF_8;

        try (FileInputStream fis = new FileInputStream(SONG_PATH)) {
            int readByte;
            int count = 0;

            // bytes[]를 인자로 넣을 시 그 용량만큼 받아온다
            // read에 아무것도 넣지 않으면 1바이트
            // 원하는 만큼 담고 싶다면 buffer를 설정해서 인자로 넣어준다는 것을 알 수 있다
            while ((readByte = fis.read(buffer)) != -1) {

                // byte[]로부터 지정된 범위와 인코딩의 문자열 생성
                String readStr = new String(
                        buffer, 0, readByte, charset
                );

                /**
                 *  주어진 바이트 수가 다 채워지지 않았다면?
                 *  남은 부분을 0으로 채운다 - 비효율적이다
                 *  때문에 BufferedInputStream을 사용하는 것이다.
                 */

                System.out.printf(
                        "\n⭐️- - - %d : %d - - -\n%n",
                        ++count, readByte
                );

                System.out.println(readStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedInputEx () {
        Charset charset = StandardCharsets.UTF_8;

        try (
                // BufferedInputStream
                // - 내부에 버퍼를 사용한다
                // 트럭에 실어서 가져온다
                // - FileInputStream을 생성자 인자로 받는다
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream(SONG_PATH)
                )
        ) {
            // 트럭에 실려온 글을 바구니(buffer)에 담아 while 문에서 문자열을 변환한다
            // 즉, 두번의 버퍼를 사용한다
            byte[] buffer = new byte[1024];
            int readByte;
            int count = 0;

            // FileInputStream의 read(byte[]) 메소드와의 차이
            // 1. 내부 버퍼(트럭)으로부터 가져오기 때문에 더욱 빠르다
            // 2. 바구니 크기보다 적게 남았을때 그만큼만 더 담아온다
            while ((readByte = bis.read(buffer)) != -1) {
                String readStr = new String(
                        buffer, 0, readByte, charset
                );
                System.out.printf(
                        "\n⭐️- - - %d : %d - - -\n%n",
                        ++count, readByte
                );

                System.out.println(readStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
