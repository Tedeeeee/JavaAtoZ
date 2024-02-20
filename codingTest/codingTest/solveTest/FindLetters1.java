package codingTest.solveTest;

import java.util.Scanner;

public class FindLetters1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        String s = sc.nextLine().toLowerCase();
        char c = s.charAt(0);

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char check = str.charAt(i);

            if (c == check) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    /*
        해당 문제는 주어지는 값이 한개인것을 이용해서 charAt(0) 으로 코딩하여 문제를 풀면 더욱 간단하고 쉬워집니다.
     */
}
