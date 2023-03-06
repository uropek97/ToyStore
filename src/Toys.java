import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

public class Toys {
    private List<Toy> toys;

    public Toys(){
        this.toys = new ArrayList<>();
    }

    public Toys(List<Toy> toys){
        this.toys = toys;
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void add(Toy toy){
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