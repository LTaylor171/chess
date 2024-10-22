package exception;

public class ResponseError extends Exception {
    private int status;
    
    public ResponseError(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
