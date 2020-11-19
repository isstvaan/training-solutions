package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {

    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    private int getActualSecondaryDamage() {
        return 1 + super.getRandom().nextInt(super.getActualPrimaryDamage() * 2);
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (getPosition().distance(enemy.getPosition()) < 2) {
            super.hit(enemy, getActualSecondaryDamage());
        }
    }
}
