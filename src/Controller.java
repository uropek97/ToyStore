import java.util.HashMap;
import java.util.Map;

public class Controller {
    private IUserInterface userInterface;
    private Map<String, Command> commands;
    private Toys toys = new Toys();
    private Clients clients = new Clients();
    private Participants participants = new Participants();

    public Controller(IUserInterface userInterface){
        this.userInterface = userInterface;

        commands = new HashMap<>();
        commands.put("addToy", new CommandAddToy(this.userInterface, this.toys));
    }

    public void Start(){
        this.userInterface.WriteLine("Старт работы");

        do{
            var input = this.userInterface.Read("Введите команду:", false);
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
        }while (true);
    }
}
