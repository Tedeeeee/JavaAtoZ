package src.sec01.chap10.ex02;

public class Tab {
    private Setting setting = null;

    public Tab() {}

    public Tab(Setting setting) {
        this.setting = setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public Setting getSetting() {
        return setting;
    }
}
