package Exceptions;

public class NotFoundError extends Exception{

    public NotFoundError(){
        super("The element was not found");
    }
}
