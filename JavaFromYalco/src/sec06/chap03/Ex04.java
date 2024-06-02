package src.sec06.chap03;

import src.sec03.chap04.MagicKnight;
import src.sec03.chap04.Side;
import src.sec03.chap04.Unit;

public class Ex04 {
    public static void superLighteningAttack(MagicKnight magicKnight, Unit enemy) {
        final int MANA_USAGE = 40;
        final int DAMAGE = 500;
        if (magicKnight.mana < MANA_USAGE) {
            throw new NotEnoughManaException(magicKnight, MANA_USAGE);
        }
        System.out.printf("⚡️⚡️⚡️ → 💀 %s%n", enemy);
        enemy.hp -= DAMAGE;
        magicKnight.mana -= MANA_USAGE;
    }

    public static void main(String[] args) {
        MagicKnight magicKnight = new MagicKnight(Side.BLUE);
        Dragon dragon = new Dragon(Side.RED);

        superLighteningAttack(magicKnight, dragon);
        superLighteningAttack(magicKnight, dragon);
    }
}
