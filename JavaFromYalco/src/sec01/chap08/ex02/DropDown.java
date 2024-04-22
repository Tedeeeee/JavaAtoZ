package src.sec01.chap08.ex02;

public class DropDown extends FormElement{
    String[] menus;

    public DropDown(int space, String[] menus) {
        super(space);
        this.menus = menus;
    }

    @Override
    void func() {
        System.out.println("메뉴를 선택해주세요");
        for (String menu : menus) {
            System.out.printf(" - %s%n", menu);
        }
    }
}
