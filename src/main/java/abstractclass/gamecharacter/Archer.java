package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {
    private int numberOfArrow;

    public Archer(Point position, Random random) {
        super(position, random);
        this.numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    private int getActualSecondaryDamage() {
        return 1 + getRandom().nextInt(5);
    }

    private void shootingAnArrow(Character enemy) {
        int damage = getActualSecondaryDamage();
        numberOfArrow--;
        super.hit(enemy, damage);
    }

    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }
}
