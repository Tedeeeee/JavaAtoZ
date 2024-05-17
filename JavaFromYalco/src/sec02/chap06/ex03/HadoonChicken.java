package src.sec02.chap06.ex03;

public class HadoonChicken {
    static HadoonChickenMenu[] menus = HadoonChickenMenu.values();

    public void takeOrder(String menuName) {
        HadoonChickenMenu ordered = null;

        for (HadoonChickenMenu menu : menus) {
            if (menu.getName().equals(menuName)) {
                ordered = menu;
            }
        }

        if (ordered == null) {
            System.out.println("해당 메뉴가 없습니다");
            return;
        }

        System.out.println(
                ordered.getPrice() + "원입니다."
        );
    }
}
