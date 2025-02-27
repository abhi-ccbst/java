package MyCustomException;

public class MyException extends RuntimeException {
    public MyException(String message, int status) {
        super(new ExceptionFormate(message, status).toString());
    }
}
