/**
 * Exception to be thrown upon a shape receiving an invalid parameter
 */
public class InvalidShapeParameterException extends Exception {
    private final static String DEFAULT_MSG = "Invalid Shape Parameter!";

    /**
     * Default Constructor
     * Throws exception with Default message
     */
    public InvalidShapeParameterException() {
        super(DEFAULT_MSG);
    }

    /**
     * Throws exception with custom message
     *
     * @param message String custom exception message
     */
    public InvalidShapeParameterException(String message) {
        super(message);
    }

    /**
     * Throws exception with custom message and throwable
     *
     * @param s         String message
     * @param throwable Throwable throwable
     */
    public InvalidShapeParameterException(String s, Throwable throwable) {
        super(s, throwable);
    }

    /**
     * Throws exception with custom throwable
     *
     * @param throwable Throwable throwable
     */
    public InvalidShapeParameterException(Throwable throwable) {
        super(throwable);
    }
}
