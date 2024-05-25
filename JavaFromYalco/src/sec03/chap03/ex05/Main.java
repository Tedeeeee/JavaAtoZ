package src.sec03.chap03.ex05;

public class Main {
    public static void main(String[] args) {

        /**
         *  제네릭으로 받는 extends에 대해 알아볼 수 있다. 해당 값을 상속받은 자손들만 사용할 수 있다는 것이다.
         */

        Horse<Unit> avante = new Horse<>();
        avante.setRider(new Unit());
        avante.setRider(new Knight());
        avante.setRider(new MagicKnight());

        Horse<Knight> sonata = new Horse<>();
        // Knight를 상속받은 클래스나 상속받은 클래스를 상속받은 누군가만이 사용할 수 있다.
        // sonata.setRider(new Unit());
        sonata.setRider(new Knight());
        sonata.setRider(new MagicKnight());

        Horse<MagicKnight> grandeur = new Horse<>();
        // grandeur.setRider(new Unit());
        // grandeur.setRider(new Knight());
        grandeur.setRider(new MagicKnight());

        // 자료형과 제네릭의 타입이 일치하지 않으면 대입이 불가능하다
        // - 기존에는 상속받으면 따로 명시하지 않아도 사용할 수 있지만
        // - 제네릭 타입이 상속관계에 있어도 마찬가지이다.
        // Horse<Unit> wromgHorse1 = new Horse<Knight>();
        // Horse<Knight> wrongHorse2 = new Horse<Unit>();

        // avante는 sonata를 담을 수 없다
        //avante = sonata;
        // sonata는 grandeur를 담을 수 없다
        //sonata = grandeur;

        // ⭐️ 와일드카드 - 제네릭 타입의 다형성을 위함

        // Knight와 그 자식 클래스만 받을 수 있다.
        // T 와 굉장히 비슷하게 사용할 수 있지만 차이점이 있다.
        // 와일드카드를 사용하면 어떤 타입이 들어올지 정확히 알 수 없을때 사용하기 좋다. 하지만 T는 값만 T라고 적었지 정확한 타입을 알고 있다는 것이다
        Horse<? extends Knight> knightHorse;
        // knightHorse = new Horse<Unit>();
        knightHorse = new Horse<Knight>();
        knightHorse = new Horse<MagicKnight>();

        // knightHorse는 Knight의 상속관계까지 연결이 가능하다
        // 때문에 sonata 이상의 차만 탈 수 있다
        // knightHorse = avante;
        knightHorse = sonata;
        knightHorse = grandeur;

        // knight와 그 조상 클래스만을 받을 수 있다
        Horse<? super Knight> nonLuxuryHorse;
        nonLuxuryHorse = avante;
        nonLuxuryHorse = sonata;
        // 이 차는 신병력일수록 탈수 없다
        //nonLuxuryHorse = grandeur;

        // 모든 유닛이 탈 수 있고 모두 살 수 있기에 bestSeller가 가능
        HorseShop.intoBestSellers(avante);
        HorseShop.intoBestSellers(sonata);
        HorseShop.intoBestSellers(grandeur);

        // 프리미엄의 말로써 일반 Unit은 탈 수 없다
        // HorseShop.intoPremiums(avante);
        HorseShop.intoPremiums(sonata);
        HorseShop.intoPremiums(grandeur);

        HorseShop.intoEntryLevels(avante);
        HorseShop.intoEntryLevels(sonata);
        // knight거나 그 조상들만 탈 수 있는 말이다
        // HorseShop.intoEntryLevels(grandeur);

        // 제네릭은 변수에 들어올 값에 대한 제한이 있다.
        // - 데이터 그 자체에 대한 것이 아니다.
        Horse[] horses = {avante, sonata, grandeur};
        for (Horse horse : horses) {
            horse.setRider(new Unit());
        }
    }
}
