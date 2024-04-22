package src.sec01.chap05.ex03;

public class Main {
    public static void main(String[] args) {
        Slime slime = new Slime();
        FireSlime fireSlime = new FireSlime();

        // 여기서 매개변수가 Slime 인데 fire가 들어갈 수 있었던것도 다형성 덕분
        slime.attack(fireSlime);
        fireSlime.attack(slime);

        System.out.println(fireSlime.hp);
        System.out.println(slime.hp);
    }
}
