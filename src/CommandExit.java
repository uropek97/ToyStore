public class CommandExit extends Command{
    private Controller controller;
    private IUserInterface userInterface;
    public CommandExit(Controller controller, IUserInterface userInterface){
        this.description = "Выход из приложения";
        this.controller = controller;
        this.userInterface = userInterface;
    }
    @Override
    public void Execute(String... params) {
        this.userInterface.WriteLine("Выход");
        this.controller.setCanWork(false);
    }
}
