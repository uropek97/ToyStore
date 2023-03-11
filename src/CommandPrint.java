public class CommandPrint extends Command{
    private Controller controller;
    private IUserInterface userInterface;

    CommandPrint(Controller controller, IUserInterface userInterface){
        this.description = "Выводит список указанного параметра (toys, clients, participants/part)";
        this.controller = controller;
        this.userInterface = userInterface;
    }


    @Override
    public void Execute(String... params) {
        if(params.length != 2){
            this.userInterface.WriteLine("Неверное количество параметров");
        }
        else {
            if(params[1].equals("toys")){
                for(var toy : this.controller.getToys().getToys())
                    this.userInterface.WriteLine(toy.toString());
            }
            else if(params[1].equals("clients")){
                for(var client : this.controller.getClients().getClients())
                    this.userInterface.WriteLine(client.toString());
            }
            else if (params[1].equals("part") || params[1].equals("participants")) {
                for(var participant : this.controller.getParticipants().getParticipants())
                    this.userInterface.WriteLine(participant.toString());
            }
            else if(params[1].equals("winners")){
                for(var winner : this.controller.getWinners().getClients())
                    this.userInterface.WriteLine(winner.toString());
            }
            else {
                this.userInterface.WriteLine("Неизвестный аргумент");
            }
        }
    }
}
