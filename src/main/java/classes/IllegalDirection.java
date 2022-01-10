package classes;

public class IllegalDirection extends RuntimeException {
    public IllegalDirection() {
        super("Direction can be up, down,left or right");
    }
}
