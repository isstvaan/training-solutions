package lambdaoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {
    List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = new ArrayList<>(members);
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        for (Member item : members) {
            if (predicate.test(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        int sumSkills = 0;
        for (Member item : members) {
            sumSkills += item.getSkills().size();
        }
        if (sumSkills > 0) {
            return Optional.of((double) sumSkills / members.size());
        }
        return Optional.empty();
    }
}
