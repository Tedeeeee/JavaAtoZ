package src.sec02.chap03.ex02;

public class HadoonChicken {
    private String name;

    public HadoonChicken(String name) {
        this.name = name;
    }

    public static class LaunchTF {
        private String title;
        private String leader;

        public LaunchTF(String title, String leader) {
            this.title = title;
            this.leader = leader;
        }

        public HadoonChicken launch() {
            return new HadoonChicken(title);
        }
    }

    class Gift {
        private String message;

        public Gift(String to) {
            this.message = "From 하둔 치킨 %s점 to %s손님"
                    .formatted(name, to);
        }
    }

    public Gift getGift(String to) {
        return new Gift(to);
    }
}
