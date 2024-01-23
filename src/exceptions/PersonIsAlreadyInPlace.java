package exceptions;

public class PersonIsAlreadyInPlace extends RuntimeException{
    public PersonIsAlreadyInPlace(String message){
        super(message);
    }
}
