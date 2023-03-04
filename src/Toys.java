import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Toys {
    private List<Toy> toys;
    private List<Toy> prizeToys;
    private Random rdm;

    public Toys(){
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
        this.rdm = new Random();
    }

    public void addToy(Toy toy){
        this.toys.add(toy);
    }

    public void updateWeight(int id, double chance){
        for(Toy toy : toys){
            if(toy.getId() == id){
                toy.setChance(chance);
                break;
            }
        }
    }
}