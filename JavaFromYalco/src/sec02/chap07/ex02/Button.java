package src.sec02.chap07.ex02;

public class Button {
    public enum ClickedBy {
        LEFT('좌'), RIGHT('우');
        private char indicator;
        ClickedBy(char indicator) {
            this.indicator = indicator;
        }

        public char getIndicator() {
            return indicator;
        }
    }

    public record ClickInfo(
            int x, int y, ClickedBy clickedBy
    ) implements InfoPrinter {
        static String desc = "버튼 클릭 정보";

        @Override
        public void printInfo() {
            System.out.printf(
                    "%c클릭 (%d, %d) %n",
                    clickedBy.indicator, x, y
            );
        }
    }

    public ClickInfo func(int x, int y, ClickedBy clickedBy) {
        System.out.println("버튼 동작");
        return new ClickInfo(x, y, clickedBy);
    }
}
