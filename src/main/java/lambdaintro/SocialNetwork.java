package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {
    List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> findMembersBy(Predicate<Member> predicate) {
        List<Member> retVal = new ArrayList<>();
        for (Member item : members) {
            if (predicate.test(item)) {
                retVal.add(item);
            }
        }
        return retVal;
    }

    public void applyToSelectedMembers(Predicate<Member> predicate, Consumer<Member> consumer) {
        for (Member item : members) {
            if (predicate.test(item)) {
                consumer.accept(item);
            }
        }
    }

    public <T> List<T> transformMembers(Function<Member, T> function) {
        List<T> retVal = new ArrayList<>();
        for (Member item : members) {
            retVal.add(function.apply(item));
        }
        return retVal;
    }
}
