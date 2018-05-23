public class InvalidShapeParameterException extends Exception{
    private final static String DEFAULT_MSG = "Invalid Shape Parameter!";

    public InvalidShapeParameterException(){
        super(DEFAULT_MSG);
    }

    public InvalidShapeParameterException(String message){
        super(message);
    }

    public InvalidShapeParameterException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public InvalidShapeParameterException(Throwable throwable) {
        super(throwable);
    }
}
