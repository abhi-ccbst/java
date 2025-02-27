package MyCustomException;

import java.time.LocalDateTime;

public class ExceptionFormate {
    private String message;
    private int status;
    private LocalDateTime timestamp;

    public ExceptionFormate(String message, int status) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
