package upao.edu.cleannow_api.exception;

public class UsuarioAlreadyExistsException extends RuntimeException{
    public UsuarioAlreadyExistsException(String message){
        super(message);
    }
}
