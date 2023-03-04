import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private List<Integer> numbers;
    private Random rdm;

    public Lottery(){

    }

    private List<Integer> getNumbers(Clients clients){
        List<Integer> numbers = new ArrayList<>();

        for(var client : clients.getParticipants()){
            numbers.add(client.getId());
        }
        return numbers;
    }
}
