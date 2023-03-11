import java.util.ArrayList;
import java.util.List;

public class Toys {
    private List<Toy> toys;
    private int totalWeight;

    public Toys(){
        this.toys = new ArrayList<>();
        this.totalWeight = 0;
    }

    public Toys(List<Toy> toys){
        this.toys = toys;
        this.totalWeight = gettingTotalWeight(toys);
    }

    public List<Toy> getToys() {
        return toys;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void add(Toy toy){
        this.toys.add(toy);
        this.totalWeight += toy.getWeight();
    }

    public void updateWeight(int id, int weight){
        for(Toy toy : toys){
            if(toy.getId() == id){
                this.totalWeight -= toy.getWeight();
                toy.setWeight(weight);
                this.totalWeight += weight;
                break;
            }
        }
    }

    private int gettingTotalWeight(List<Toy> toys){
        int totalWeight = 0;
        for(var toy : toys){
            totalWeight += toy.getWeight();
        }
        return totalWeight;
    }

    public void reduceAmount(Toy toy, int amount){
        if(this.toys.contains(toy)) {
            toy.reduceAmount(amount);
            if(toy.getAmount() <= 0){
                this.toys.remove(toy);
            }
        }
    }
}