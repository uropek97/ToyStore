import java.util.ArrayList;
import java.util.List;

public class Participants{
    private static int  threshold = 1000;
    private List<Client> participants;

    public Participants(){
        this.participants = new ArrayList<>();
    }

    public Participants(Clients clients, Clients winners){
        this.participants = gettingParticipants(clients, winners);
    }

    public Participants(List<Client> participants){
        this.participants = participants;
    }

    public List<Client> getParticipants() {
        return participants;
    }

    public static int getThreshold() {
        return threshold;
    }

    public static void setThreshold(int threshold) {
        Participants.threshold = threshold;
    }

    private List<Client> gettingParticipants(Clients clients, Clients winners){
        List<Client> participants = new ArrayList<>();
        for(var client : clients.getClients()){
            if(client.getSum() >= threshold){
                participants.add(client);
            }
        }
        for(var winner : winners.getClients())
                participants.remove(winner);

        return participants;
    }

    public boolean add(Client client){
        if(client.getSum() >= threshold){
            this.participants.add(client);
            return true;
        }
        else {
            return false;
        }
    }
}
