package src.sec06.chap03;

import src.sec03.chap04.MagicKnight;

public class NotEnoughManaException extends RuntimeException{
    public NotEnoughManaException(MagicKnight mk, int neededMana) {
        super(
                "마나가 %d이 부족합니다"
                        .formatted(neededMana - mk.mana)
        );
    }
}
