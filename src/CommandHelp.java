public class CommandHelp extends Command{
    private Controller controller;
    private IUserInterface userInterface;

    CommandHelp(Controller controller, IUserInterface userInterface){
        this.description = "Выводит информацию о командах";
        this.controller = controller;
        this.userInterface = userInterface;
    }
    @Override
    public void Execute(String... params) {
        var a = this.controller.getCommands();
        for(var key : a.keySet()){
            this.userInterface.Write(String.format("%s - ", key));
            this.userInterface.WriteLine(a.get(key).description);
        }
    }
}
