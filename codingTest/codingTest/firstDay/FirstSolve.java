package codingTest.firstDay;

public class FirstSolve {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 110011;
        int k = 10;
        s.solution(n, k);
    }
}

class Solution {
    public int solution(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }
        int answer = 0;
        String num = "";

        while (n != 0) {
            num += String.valueOf(n % k);
            n /= k;
        }

        StringBuilder sb = new StringBuilder(num).reverse();

        num = sb.toString();

        String[] split = num.split("0");

        int count = 0;
        for (String s : split) {
            if (s.isEmpty()) continue;
            long number = Long.parseLong(s);
            if (formation(number)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean formation(Long n) {
        if (n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ((n % i) == 0) return false;
        }

        return true;
    }
}
