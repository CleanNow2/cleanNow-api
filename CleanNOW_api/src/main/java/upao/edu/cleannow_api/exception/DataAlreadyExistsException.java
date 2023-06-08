package upao.edu.cleannow_api.exception;

public class DataAlreadyExistsException extends RuntimeException{
    public DataAlreadyExistsException(String message){
        super(message);
    }
}
