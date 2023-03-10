import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private Random rdm;

    public ToyStore(){
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
        this.rdm = new Random();
    }

    public void addToy(Toy toy){
        this.toys.add(toy);
    }

    public void updateWeight(int id, int weight){
        for(Toy toy : toys){
            if(toy.getId() == id){
                toy.setWeight(weight);
                break;
            }
        }
    }
}
