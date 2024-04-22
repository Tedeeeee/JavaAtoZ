package src.sec01.chap09.ex02;

public class Main {
    public static void main(String[] args) {
        FoodSafety.announcement();

        HadoonChicken store1 = new HadoonChicken();

        store1.regularInspection();
        store1.cleanKitchen();
        store1.employeeEducation();
    }
}
