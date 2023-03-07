public abstract class Command {
    public String description;
    public abstract void Execute(String... params);
}
