package methoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> pubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        pubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub bestPub = pubs.get(0);

        for (int i = 1; i < pubs.size(); i++) {
            if (pubs.get(i).getOpenFrom().isEarlier(bestPub.getOpenFrom())) {
                bestPub = pubs.get(i);
                i = 0;
            }
        }
        return bestPub;
    }
}
