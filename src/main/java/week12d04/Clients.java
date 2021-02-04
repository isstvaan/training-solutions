package week12d04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clients {
    Map<String, Client> clients = new HashMap<>();

    public void addClient(String regNumber, String name) {
        clients.put(regNumber, new Client(name, regNumber));
    }

    public Client findByRegNumber(String regNumber) {
        if (clients.containsKey(regNumber)) {
            return clients.get(regNumber);
        }
        throw new IllegalArgumentException("Client not found!");
    }

    public List<Client> findByName(String name) {
        List<Client> retVal = new ArrayList<>();
        for (Client client : clients.values()) {
            if (client.getName().contains(name)) {
                retVal.add(client);
            }
        }
        return retVal;
    }

    public static void main(String[] args) {
        Clients clients = new Clients();
        clients.addClient("1111", "Béla");
        clients.addClient("1112", "Rozi");
        clients.addClient("1113", "Feri");
        System.out.println(clients.findByRegNumber("1111").getName());
        //  System.out.println(clients.findByRegNumber("1114"));
        System.out.println(clients.findByName("Bé").get(0).getName());
    }
}
