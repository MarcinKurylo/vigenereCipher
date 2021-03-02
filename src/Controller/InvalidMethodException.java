package Controller;

public class InvalidMethodException extends Exception{

    InvalidMethodException(){
        super("Invalid method selector");
    }
}
