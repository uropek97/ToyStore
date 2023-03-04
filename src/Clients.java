import java.util.ArrayList;
import java.util.List;

public class Clients {
    private static int  threshold = 1000;

    private List<Client> clients;
    private List<Client> participants;

    public List<Client> getClients() {
        return clients;
    }

    public List<Client> getParticipants() {
        return participants;
    }

    public Clients(){
        this.clients = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public void add(Client client){
        this.clients.add(client);
        if(client.getSum() >= threshold){
            this.participants.add(client);
        }
    }
}
