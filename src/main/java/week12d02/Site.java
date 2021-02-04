package week12d02;

public class Site implements Comparable<Site> {

    private int houseNumber;
    private final boolean evenSite;
    private final int siteWidth;
    private final String fenceColor;

    public Site(boolean evenSite, int siteWidth, String fenceColor) {
        this.evenSite = evenSite;
        this.siteWidth = siteWidth;
        this.fenceColor = fenceColor;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getSiteWidth() {
        return siteWidth;
    }

    public String getFenceColor() {
        return fenceColor;
    }

    public boolean isEvenSite() {
        return evenSite;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public int compareTo(Site o) {
        return siteWidth - o.siteWidth;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < siteWidth; i++) {
            stringBuilder.append(fenceColor);
        }

        return "(" + houseNumber + ")" + stringBuilder.toString();
    }
}
