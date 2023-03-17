public class CommandHoldLottery extends Command{
    private Controller controller;
    private IUserInterface userInterface;

    public  CommandHoldLottery(Controller controller, IUserInterface userInterface){
        this.description = "Проведение лоетереи";
        this.controller = controller;
        this.userInterface = userInterface;
    }
    @Override
    public void Execute(String... params) {
        if(params.length != 1){
            this.userInterface.WriteLine("Неверное количество параметров");
        }
        else {
            var lottery = new Lottery(this.controller.getParticipants(), this.controller.getToys());

            if(this.controller.getToys().getToys().size() == 0){
                this.userInterface.WriteLine("Нечего разыгрвать");
                return;
            }
            if(this.controller.getParticipants().getParticipants().size() == 0){
                this.userInterface.WriteLine("Нет участников");
                return;
            }
            var prize = lottery.selectToy();
            var winner = lottery.selectParticipant();

            this.userInterface.WriteLine("Приз: " + prize + "\nПобедитель: " + winner);
            this.controller.getToys().reduceAmount(prize, 1);
            this.controller.getParticipants().getParticipants().remove(winner);
            this.controller.getWinners().getClients().add(winner);

            FileWorker.write(Controller.getFileToys(), this.controller.getToys());
            FileWorker.write(Controller.getFileParticipants(), this.controller.getParticipants());
            FileWorker.write(Controller.getFileWinners(), this.controller.getWinners());
        }
    }
}
