package methodpass.troopers;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getPosX() {
        return x;
    }

    public double getPosY() {
        return y;
    }

    public double distanceFrom(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position can't be null");
        }

        return Math.sqrt((Math.pow(x - position.getPosX(), 2) + Math.pow(y - position.getPosY(), 2)));
    }
}
