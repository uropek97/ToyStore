import java.util.Random;

public class Lottery {
    private Participants participants;
    private Toys toys;
    private Random rdm;

    public Lottery(){
        this.participants = new Participants();
        this.toys = new Toys();
        this.rdm = new Random();
    }
    public Lottery(Participants participants, Toys toys){
        this();
        this.participants = participants;
        this.toys = toys;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Toys getToys() {
        return toys;
    }

    public Toy selectToy(){
        int randomWeight = this.rdm.nextInt(this.toys.getTotalWeight());
        int weightCount = 0;

        for(var toy : this.toys.getToys()){
            weightCount += toy.getWeight();
            if(randomWeight <= weightCount){
                return toy;
            }
        }
        return null;
    }

    public Client selectParticipant(){
        return this.participants.getParticipants().get(this.rdm.nextInt(this.participants.getParticipants().size()));
    }
}
