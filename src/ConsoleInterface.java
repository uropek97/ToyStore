import java.util.Scanner;

public class ConsoleInterface implements IUserInterface{
    @Override
    public void Write(String message) {
        System.out.print(message);
    }

    @Override
    public void WriteLine(String message) {
        System.out.println(message);
    }

    @Override
    public String Read(String prompt, boolean newLine) {
        Scanner scanner = new Scanner(System.in);
        if(newLine)
            this.WriteLine(prompt);
        else
            this.Write(prompt);
        return scanner.nextLine();
    }
}
