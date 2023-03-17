import java.util.ArrayList;
import java.util.List;

public class Clients {

    private  List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public Clients(){
        this.clients = new ArrayList<>();
    }

    public Clients(List<Client> clients){
        this();
        this.clients = clients;
    }

    public void add(Client client){
        this.clients.add(client);
    }
    public void setCommId(){
        int max = 0;
        for(var client : this.clients){
            if(max < client.getId())
                max = client.getId();
        }
        Client.setIdComm(max);
    }
}
