import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private List<Integer> numbers;
    private List<Integer> toys;
    private Random rdm;

    public Lottery(){
        this.numbers = new ArrayList<>();
        this.toys = new ArrayList<>();
        this.rdm = new Random();
    }
    public Lottery(List<Integer> numbers, List<Integer> toys){
        this.numbers = numbers;
        this.toys = toys;
        this.rdm = new Random();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getToys() {
        return toys;
    }

    private List<Integer> gettingNumbers(Participants participants){
        List<Integer> numbers = new ArrayList<>();

       for(var participant : participants.getParticipants()){
            numbers.add(participant.getId());
        }
        return numbers;
    }

    public boolean addNumber(int number){
        if(this.numbers.contains(number)){
            return false;
        }
        else{
            this.numbers.add(number);
            return true;
        }
    }

    private List<Integer> gettingToys(Toys toys){
        List<Integer> numbersToys = new ArrayList<>();

        for(var toy : toys.getToys()){
            if(toy.getAmount() > 0){
                numbers.add(toy.getId());
            }
        }
        return numbers;
    }
}
