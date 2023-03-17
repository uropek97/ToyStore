public class CommandAdd extends Command {

    private Controller controller;
    private IUserInterface userInterface;

    public CommandAdd(Controller controller, IUserInterface userInterface){
        this.description = "Добавляет указанную сущность(toy, client)";
        this.controller = controller;
        this.userInterface = userInterface;
    }
    @Override
    public void Execute(String... params) {
        if(params.length != 2){
            this.userInterface.WriteLine("Неверное количество параметров");
        }
        else {
            var toy = new Toy();
            var client = new Client();
            var ifChangeToy = false;
            var ifChangeClient = false;
            if(params[1].equals("toy")){
                toy.setName(this.userInterface.Read("Название: ", false));
                toy.setPrice(Double.parseDouble(this.userInterface.Read("Цена: ", false)));
                toy.setAmount(Integer.parseInt(this.userInterface.Read("Количество: ", false)));
                toy.setWeight(Integer.parseInt(this.userInterface.Read("Вес в %: ", false)));
                ifChangeToy = true;
            }
            else if(params[1].equals("client")){
                client.setName(this.userInterface.Read("Имя клиента: ", false));
                client.buy(Double.parseDouble(this.userInterface.Read("Сумма покупки: ", false)));
                ifChangeClient = true;
            }
            else {
                this.userInterface.Write("Неизвестный параметр");
            }
            if(ifChangeToy){
                this.controller.getToys().add(toy);
                FileWorker.write(Controller.getFileToys(), this.controller.getToys());
            }
            if(ifChangeClient){
                this.controller.getClients().add(client);
                FileWorker.write(Controller.getFileClients(), this.controller.getClients());
                var ifChangePart = this.controller.getParticipants().add(client);
                if(ifChangePart)
                    FileWorker.write(Controller.getFileParticipants(), this.controller.getParticipants());
            }
        }
    }
}
