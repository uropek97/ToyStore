import java.util.Set;

public class Toy{
    private static  int idComm;
    private int id;
    private String name;
    private int amount;
    private double chance;

    Toy(String name, int amount, double chance){
        this.id = ++idComm;
        this.name = name;
        this.amount = amount;
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public void reduceAmount(int amount){
        this.amount -= amount;
    }

    @Override
    public String toString(){
        return String.format("ID: %d, Игрушка: %s, Количество: %d", this.id, this.name, this.amount);
    }
}
