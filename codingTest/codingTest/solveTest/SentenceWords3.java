package codingTest.solveTest;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SentenceWords3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();

        int max = 0;
        String answer = "";
        StringTokenizer st = new StringTokenizer(next, " ");
        int num = st.countTokens();
        for (int i = 0; i < num; i++) {
            String s = st.nextToken();
            int length = s.length();
            if (max < length) {
                max = length;
                answer = s;
            }
        }
        System.out.println(answer);
    }

    /*
        해당 문제는 StringTokenizer 를 사용하는 방법을 아는 것이 중요합니다.

    */
}
