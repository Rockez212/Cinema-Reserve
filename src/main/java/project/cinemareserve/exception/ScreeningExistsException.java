package project.cinemareserve.exception;

public class ScreeningExistsException extends RuntimeException {
    public ScreeningExistsException(String message) {
        super(message);
    }
}
