public class Client {
    private static int idComm = 0;
    private int id;
    private String name;
    private double sum;

    public Client() {
        this.id = ++idComm;
        this.sum = 0;
    }

    public Client(int id, String name, double sum){
        this.id = id;
        idComm++;
        this.name = name;
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }

    public double buy(double buy){
        this.sum += buy;
        return this.sum;
    }
}