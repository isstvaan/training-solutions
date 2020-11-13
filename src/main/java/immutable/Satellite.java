package immutable;

public class Satellite {
    private CelestialCoordinates destinationCoordinates;
    private final String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (destinationCoordinates == null) {
            throw new IllegalArgumentException("destinationCoordinates parameter must not be null.");
        }
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("registerIdent parameter must not be null.");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(
                destinationCoordinates.getX() + diff.getX(),
                destinationCoordinates.getY() + diff.getY(),
                destinationCoordinates.getZ() + diff.getZ());
    }

    @Override
    public String toString() {
        return registerIdent + ": " + destinationCoordinates;
    }

    private boolean isEmpty(String string) {
        return string == null || string.isBlank();
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }
}
