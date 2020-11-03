package socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> connections;

    public Member(String name) {
        this.name = name;
        connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectMember(Member member) {
        this.connections.add(member);
    }

    public List<String> connectedNames() {
        List<String> names = new ArrayList<>();
        for (Member member : connections) {
            names.add(member.getName());
        }
        return names;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", connections=" + connectedNames().toString() +
                '}';
    }
/*
    @Override
    public String toString() {
        return name + " " + connections.toString();
    }

 */
}
