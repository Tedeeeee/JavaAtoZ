package src.sec03.chap04;

public class MagicKnight extends Knight{
    public int mana = 60;
    public final int MANA_USAGE = 4;
    public MagicKnight(Side side) {
        super(side);
    }

    public void lighteningAttack(Unit[] targets) {
        for (Unit target : targets) {
            // 맞은애가 마법사면 무효
            if (target instanceof MagicKnight) continue;
            // 마나가 없으면 사용 불가
            if (mana < MANA_USAGE) break;
            System.out.printf("⚡️ → 💀 %s%n", target);
            target.hp -= 8;
            mana -= MANA_USAGE;
        }
    }

    @Override
    public String toString() {
        return side.toString() + " 진영 마법기사";
    }
}
