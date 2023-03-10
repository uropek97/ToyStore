import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static String fileToys = "toys.json";
    private static String fileClients = "clients.json";
    private static String fileParticipants = "participants.json";

    private IUserInterface userInterface;
    private Map<String, Command> commands;
    private Toys toys = new Toys();
    private Clients clients = new Clients();
    private Participants participants = new Participants();

    private boolean canWork;

    public Controller(IUserInterface userInterface){
        this.userInterface = userInterface;

        var help = new CommandHelp(this, this.userInterface);
        var exit = new CommandExit(this, this.userInterface);
        commands = new HashMap<>();
        commands.put("addToy", new CommandAddToy(this.userInterface, this.toys));
        commands.put("addClient", new CommandAddClient(this.userInterface, this.clients));
        commands.put("help", help);
        commands.put("?", help);
        commands.put("exit", exit);
        commands.put("quit", exit);
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

    public void Start(){
        this.userInterface.WriteLine("Старт работы");

        this.toys = FileWorker.read(fileToys, Toys.class);
        this.clients = FileWorker.read(fileClients, Clients.class);
        this.participants = FileWorker.read(fileParticipants, Participants.class);

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
