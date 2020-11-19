package abstractclass.gamecharacter;

public class BattleField {
    private int round = 0;

    public int getRound() {
        return round;
    }

    public boolean oneHit(Character attacker, Character defender) {
        if (!attacker.isAlive() || !defender.isAlive()) {
            return false;
        }
        attacker.primaryAttack(defender);

        if (!attacker.isAlive() || !defender.isAlive()) {
            return false;
        }
        attacker.secondaryAttack(defender);
        return true;
    }

    public Character fight(Character one, Character other) {
        while (true) {
            round++;
            if (!oneHit(one, other)) {
                break;
            }
            round++;
            if (!oneHit(other, one)) {
                break;
            }
        }
        return one.isAlive() ? one : other;
    }
}
