package src.sec01.chap03.ex02;

public class HadoonChicken {
    static String brand = "하둔치킨";
    static String contact() {
        return "%s입니다. 무엇을 도와드릴까요?".formatted(brand);
    }
    static int lastNo = 0;
    int no = ++lastNo;
    String name;
    HadoonChicken(String name) {
        this.name = name;
    }

    String intro() {
        return "안녕하세요. %s %d호 %s호점입니다."
                .formatted(brand, no, name);
    }
}
