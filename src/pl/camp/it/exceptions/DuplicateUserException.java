package pl.camp.it.exceptions;

public class DuplicateUserException extends Exception {
    private String errorInfo;

    public DuplicateUserException(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }
}
