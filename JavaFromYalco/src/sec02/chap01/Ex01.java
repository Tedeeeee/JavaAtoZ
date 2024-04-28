package src.sec02.chap01;

public class Ex01 {
    public static void main(String[] args) {
        {
            int x = 1;
            System.out.println(x);
        }

        {
            int intNum = 123;
            String str = "블록 밖은 위험해";
        }

        //intNum = 234;
        //System.out.println(str);

        String x = "전국구 보스";

        {
            String y = "동네 양아치";

            System.out.println(x);
            System.out.println(y);
        }

        System.out.println(x);
        //System.out.println(y);

        int z = 1;

        for (int i = 0; i < 5; i++) {
            System.out.println(z + i);
        }

        // System.out.println(i);
    }

}
