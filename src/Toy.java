public class Toy{
    private static  int idComm;
    private int id;
    private String name;
    private int amount;

    private int weight;

    Toy(){
        this.id = ++idComm;
    }

    Toy(String name, int amount, int weight){
        this();
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }

    Toy(int id, String name, int amount, int weight){
        this(name, amount, weight);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void reduceAmount(int amount){
        this.amount -= amount;
    }

    @Override
    public String toString(){
        return String.format("ID: %d, Игрушка: %s, Количество: %d, Вес: %d", this.id, this.name, this.amount, this.weight);
    }
}
