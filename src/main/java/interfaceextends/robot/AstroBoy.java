package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {
    public static final long ALTITUDE = 5;
    private Point position;
    private int angle;
    private List<Point> path;

    public AstroBoy(Point position) {
        this.position = position;
        angle = 0;
        path = new ArrayList<>();
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    public long getAltitude() {
        return position.getZ();
    }

    @Override
    public void liftTo(long altitude) {
        Point newPosition = new Point(this.position.getX(), this.position.getY(), altitude);
        path.add(newPosition);
        this.position = newPosition;
    }

    @Override
    public void moveTo(Point position) {
        path.add(position);
        this.position = position;
    }

    @Override
    public void fastMoveTo(Point position) {
        liftTo(ALTITUDE);
        moveTo(new Point(position.getX(), position.getY(), ALTITUDE));
        liftTo(0);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return path;
    }
}
