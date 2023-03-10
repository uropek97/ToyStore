public class CommandAddClient extends Command{
    private Clients clients;
    private IUserInterface userInterface;
    CommandAddClient(IUserInterface userInterface, Clients clients){
        this.description = "Добавляет клиента в список";
        this.userInterface = userInterface;
        this.clients = clients;
    }
    @Override
    public void Execute(String... params) {
        var ifChange = false;
        if(params.length > 1){
            if(params.length != 3){
                this.userInterface.WriteLine("Неверное количество параметров");
            }
            else{
                var name = params[1];
                var sum = Double.parseDouble(params[2]);
                this.clients.add(new Client(name, sum));
                ifChange = true;
            }
        }
        else{
            var name = this.userInterface.Read("Имя клиента: ", false);
            var sum = Double.parseDouble(this.userInterface.Read("Сумма покупок: ", false));
            this.clients.add(new Client(name, sum));
            ifChange = true;
        }
        if(ifChange)
            FileWorker.write(Controller.getFileClients(), this.clients);
    }
}
