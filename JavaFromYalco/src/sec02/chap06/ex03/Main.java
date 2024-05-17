package src.sec02.chap06.ex03;

public class Main {
    public static void main(String[] args) {
        HadoonChickenMenu menu1 = HadoonChickenMenu.YN;
        HadoonChickenMenu menu2 = HadoonChickenMenu.RS;
        HadoonChickenMenu menu3 = HadoonChickenMenu.XX;

        String menu1Name = menu1.getName();
        int menu2Price = menu2.getPrice();
        String menu3Desc = menu3.getDesc();

        menu2.setPrice(16000);
        int menu2NewPrice = menu2.getPrice();

        // 열거형의 메소드들
        HadoonChickenMenu[] byNames = new HadoonChickenMenu[] {
                HadoonChickenMenu.valueOf("FR"),
                HadoonChickenMenu.valueOf("PP"),
                HadoonChickenMenu.valueOf("GJ"),
        };

        String[] names = new String[] {
                menu1.name(), menu2.name(), menu3.name()
        };

        // 순번을 반환한다.
        int[] orders = new int[] {
            menu1.ordinal(), menu2.ordinal(), menu3.ordinal()
        };

        HadoonChickenMenu[] menus = HadoonChickenMenu.values();

        for (HadoonChickenMenu menu : menus) {
            System.out.println(menu.getDesc());
        }

        System.out.println("\n- - - - - - -\n");

        HadoonChicken store1 = new HadoonChicken();

        for (String s : "양념치킨,능이백숙,땡초치킨".split(",")) {
            store1.takeOrder(s);
        }
    }
}
