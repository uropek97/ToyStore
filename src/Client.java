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

    public static int getIdComm() {
        return idComm;
    }

    public static void setIdComm(int idComm) {
        Client.idComm = idComm;
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
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        var cl = (Client)obj;
        return this.name.equals(cl.name) && this.sum == cl.sum && this.id == cl.id;
    }

    @Override
    public String toString(){
        return String.format("%d: Имя: %s, Сумма: %.2f", this.id, this.name, this.sum);
    }
}