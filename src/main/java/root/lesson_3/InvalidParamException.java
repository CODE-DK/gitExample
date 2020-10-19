package root.lesson_3;

public class InvalidParamException extends RuntimeException {

    public InvalidParamException() {
    }

    public InvalidParamException(String message) {
        super(message);
    }
}
