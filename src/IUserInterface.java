public interface IUserInterface {
    void Write(String message);
    void WriteLine(String message);
    String Read(String prompt, boolean newLine);
}
