public class Toy{
    private static  int idComm;
    private int id;
    private String name;
    private double price;
    private int amount;
    private int weight;

    Toy(){
        this.id = ++idComm;
    }

    Toy(String name, double price, int amount, int weight){
        this();
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.weight = weight;
    }

    Toy(int id, String name, double price, int amount, int weight){
        this(name, price, amount, weight);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public static void setIdComm(int idComm) {
        Toy.idComm = idComm;
    }

    @Override
    public String toString(){
        return String.format("ID: %d, Игрушка: %s, Цена: %.2f, Количество: %d, Вес: %d", this.id, this.name, this.price, this.amount, this.weight);
    }
}
