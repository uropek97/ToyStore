public class Client {
    private static int idComm = 0;
    private int id;
    private String name;
    private double sum;

    public Client() {
        this.id = ++idComm;
        this.sum = 0;
    }
    public Client(String name, double sum){
        this();
        this.name = name;
        this.sum = sum;
    }

    public Client(int id, String name, double sum){
        this(name, sum);
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double buy(double buy){
        this.sum += buy;
        return this.sum;
    }
    @Override
    public String toString(){
        return String.format("%d: Имя: %s, Сумма: %.2f", this.id, this.name, this.sum);
    }
}