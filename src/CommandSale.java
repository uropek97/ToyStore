public class CommandSale extends Command{
    private Controller controller;
    private IUserInterface userInterface;

    public CommandSale(Controller controller, IUserInterface userInterface){
        this.description = "Осуществление продажи (если есть параметры - воспринимаются как имя)";
        this.controller = controller;
        this.userInterface = userInterface;
    }
    @Override
    public void Execute(String... params) {
        String name;
        if(params.length == 1){
            name = this.userInterface.Read("Имя: ", false);
        }
        else{
            StringBuilder SBname = new StringBuilder();
            for(int i = 1; i < params.length; i++){
                SBname.append(params[i]).append(" ");
            }
            name = SBname.toString().trim();
        }
        buying(name);
    }

    private void buying(String name){
        Client customer = null;
        var ifNotExisted = false;
        for(var client : this.controller.getClients().getClients()){
            if(client.getName().equals(name))
                customer = client;
        }
        if(customer == null){
            customer = new Client();
            customer.setName(name);
            customer.setSum(0);
            ifNotExisted = true;
        }
        var toyName = this.userInterface.Read("Название игрушки: ", false);
        Toy sell = null;
        for(var toy : this.controller.getToys().getToys()){
            if(toy.getName().equals(toyName))
                sell = toy;
        }

        if(sell == null)
            return;

        var amount = Integer.parseInt(this.userInterface.Read("Количество: ", false));
        if(amount > sell.getAmount()){
            this.userInterface.WriteLine(String.format("В наличии только %d %s", sell.getAmount(), sell.getName()));
            var confirm = this.userInterface.Read(String.format("Подтвердить заказ на %d штук? " +
                    "(для подтверждения - \"да\") :", sell.getAmount()), false);
            if(confirm.equals("да")){
                amount = sell.getAmount();
            }
            else{
                this.userInterface.WriteLine("Отмена покупки");
                return;
            }
        }

        customer.buy(sell.getPrice() * amount);
        this.controller.getToys().reduceAmount(sell, amount);

        if(ifNotExisted)
            this.controller.getClients().add(customer);
        FileWorker.write(Controller.getFileClients(), this.controller.getClients());
        FileWorker.write(Controller.getFileToys(), this.controller.getToys());

        var ifPart = this.controller.getParticipants().add(customer);
        if(ifPart)
            FileWorker.write(Controller.getFileParticipants(), this.controller.getParticipants());

        this.userInterface.WriteLine(String.format("Покупка на сумму %.2f совершена успешно", sell.getPrice() * amount));
    }
}
