package root.lesson_5.exceptions;

public class FileNotSupportedException extends RuntimeException {

    public FileNotSupportedException() {
    }

    public FileNotSupportedException(String message) {
        super(message);
    }
}
