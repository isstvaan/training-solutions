package immutable;

import java.util.List;

public class SpaceAgency {
    private List<Satellite> satellites;

    public void registerSatellite(Satellite satellite) {
        satellites.add(satellite);
    }

    public Satellite findSatelliteByRegisterIdent(String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("registerIdent parameter must not be null.");
        }

        for (Satellite item : satellites) {
            if (item.getRegisterIdent().equalsIgnoreCase(registerIdent)) {
                return item;
            }
        }

        throw new IllegalArgumentException(registerIdent + " satelite not registered!");
    }

    private boolean isEmpty(String string) {
        return string != null && !string.isBlank();
    }

    @Override
    public String toString() {
        return satellites.toString();
    }
}
