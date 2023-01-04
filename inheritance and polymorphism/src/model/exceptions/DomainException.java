package model.exceptions;
// Exceção personalizada
public class DomainException extends RuntimeException {
    public DomainException(String msg){
        super(msg);
    }
}
