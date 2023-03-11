import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static String fileToys = "toys.json";
    private static String fileClients = "clients.json";
    private static String fileParticipants = "participants.json";
    private static String fileWinners = "winners.json";

    private IUserInterface userInterface;
    private Map<String, Command> commands;
    private Toys toys = new Toys();
    private Clients clients = new Clients();
    private Participants participants = new Participants();
    private Clients winners = new Clients();

    private boolean canWork;

    public Controller(IUserInterface userInterface){
        this.userInterface = userInterface;

        var help = new CommandHelp(this, this.userInterface);
        var exit = new CommandExit(this, this.userInterface);
        var print = new CommandPrint(this, this.userInterface);
        commands = new HashMap<>();
        commands.put("add", new CommandAdd(this, this.userInterface));
        commands.put("help", help);
        commands.put("?", help);
        commands.put("exit", exit);
        commands.put("quit", exit);
        commands.put("print", print);
        commands.put("prt", print);
        commands.put("lottery", new CommandHoldLottery(this, this.userInterface));

        var cl = FileWorker.read(fileClients, Clients.class);
        if(cl != null)
            this.clients = cl;
        var t = FileWorker.read(fileToys, Toys.class);
        if(t != null)
            this.toys = t;
        var w = FileWorker.read(fileWinners, Clients.class);
        if(w!=null)
            this.winners = w;
        if(this.clients != null)
            this.participants = new Participants(this.clients, this.winners);

        this.canWork = true;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void setCanWork(boolean canWork) {
        this.canWork = canWork;
    }

    public static String getFileToys() {
        return fileToys;
    }

    public static String getFileClients() {
        return fileClients;
    }

    public static String getFileParticipants() {
        return fileParticipants;
    }

    public static String getFileWinners() {
        return fileWinners;
    }

    public Toys getToys() {
        return toys;
    }

    public Clients getClients() {
        return clients;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Clients getWinners() {
        return winners;
    }

    public IUserInterface getUserInterface() {
        return userInterface;
    }

    public void Start(){
        this.userInterface.WriteLine("Старт работы");

        do{
            var input = this.userInterface.Read("Введите команду: ", false).trim();
            var params = input.split(" ");
            var comm_name = params[0];

            if(!commands.containsKey(comm_name)){
                this.userInterface.WriteLine(String.format("Неизвестная команда %s.", comm_name));
                this.userInterface.WriteLine("Для справки введите help, для выхода quit");
                continue;
            }
            try{
               var comm = commands.get(comm_name);
               comm.Execute(params);
            }catch (Exception e){
                this.userInterface.WriteLine(e.getMessage());
            }
        }while (this.canWork);
    }
}
