package services.academicservice.exception;

public class CareerNotValidException extends RuntimeException {

    public CareerNotValidException(String message) {
        super(message);
    }

    public CareerNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CareerNotValidException(Throwable cause) {
        super(cause);
    }


}
