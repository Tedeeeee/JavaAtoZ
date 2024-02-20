package codingTest.solveTest;

import java.util.Scanner;
public class CaseConversion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] charArray = str.toCharArray();

        String answer = "";
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLowerCase(charArray[i])) {
                answer += Character.toUpperCase(charArray[i]);
            } else {
                answer += Character.toLowerCase(charArray[i]);
            }
        }
        System.out.println(answer);
    }

    /*
        Character 를 사용하는 방법을 알아야 합니다.
        isLowerCase -> 해당 글자가 소문자인가?
        isUpperCase -> 해당 글자가 대문자인가?
        toLowerCase -> 해당 글자를 소문자로 변경
        toUpperCase -> 해당 글자를 대문자로 변경
     */
}
