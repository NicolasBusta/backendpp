package services.academicservice.exception;

public class CareerNotFoundException extends RuntimeException {

    public CareerNotFoundException(String message) {
        super(message);
    }

    public CareerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CareerNotFoundException(Throwable cause) {
        super(cause);
    }

}
