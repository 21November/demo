package home.demo.users.application.services.exception;

public class UserPasswordInvalidException extends Exception {
    public UserPasswordInvalidException() {
        super("Invalid password was entered!");
    }
}
