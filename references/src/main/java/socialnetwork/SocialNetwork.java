package socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }

    public void connect(String name, String otherName) {
        Member member1 = null;
        Member member2 = null;

        for (Member item : members) {
            if (item.getName().equals(name)) {
                member1 = item;
            }
            if (item.getName().equals(otherName)) {
                member2 = item;
            }
            if (member1 != null && member2 != null) {
                member1.connectMember(member2);
                return;
            }
        }
    }

    public Member findByName(String name) {
        for (Member item : members) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();

        for (Member item1 : members) {
            for (Member item2 : item1.getConnections()) {
                if (item2.getConnections().contains(item1)) {
                    connections.add(item1.getName() + " -> " + item2.getName());
                }
            }
        }

        return connections;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "members=" + members.toString() +
                '}';
    }
}
