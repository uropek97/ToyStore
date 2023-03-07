public class CommandAddToy extends Command{
    private IUserInterface userInterface;
    private Toys toys;

    CommandAddToy(IUserInterface userInterface, Toys toys){
        this.description = "Добавляет игрушку в список";
        this.userInterface = userInterface;
        this.toys = toys;
    }

    @Override
    public void Execute(String... params) {
        if(params.length > 1){
            if(params.length != 4){
                this.userInterface.WriteLine("Неверное количество параметров");
            }
            else {
                var name = params[1];
                var amount = Integer.parseInt(params[2]);
                var weight = Integer.parseInt(params[3]);
                this.toys.add(new Toy(name, amount, weight));
            }
        }
        else{
            var name = this.userInterface.Read("Назвиние игрушки: ", false);
            var amount = Integer.parseInt(this.userInterface.Read("Количество игрушек: ", false));
            var weight = Integer.parseInt(this.userInterface.Read("Вес игрушки: ", false));
            this.toys.add(new Toy(name, amount, weight));
        }
    }
}
