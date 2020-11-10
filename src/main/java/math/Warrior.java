package math;

import java.util.Random;

public class Warrior {
    private String name;
    private int stamina;
    private double skill;

    private Point location;

    public Warrior(String name, Point location) {
        Random random = new Random();

        this.name = name;
        this.location = location;

        while (stamina < 20) {
            stamina = random.nextInt(100);
        }

        skill = random.nextDouble();
    }

    public Point getPosition() {
        return location;
    }

    public void move(Warrior warrior) {
        int x = location.getX();
        int y = location.getY();

        if (warrior.getPosition().getX() > location.getX()) {
            x++;
        } else if (warrior.getPosition().getX() < location.getX()) {
            x--;
        }
        if (warrior.getPosition().getY() > location.getY()) {
            y++;
        } else if (warrior.getPosition().getY() < location.getY()) {
            y--;
        }

        location = new Point(x, y);
    }

    public double distance(Warrior warrior) {
        return location.distance(warrior.getPosition());
    }

    public void attack(Warrior enemy) {
        if (skill > new Random().nextDouble()) {
            stamina -= new Random().nextInt(4);
        }
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public String toString() {
        return name + ": (" + location.getX() + "," + location.getY() + ") " + stamina;
    }

}

