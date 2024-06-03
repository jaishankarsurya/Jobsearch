/**
 * InvalidTemperatureException is an exception that gets thrown if
 * a user tried to create a Temperature object using an invalid 
 * temperature, which is one below absolute zero.
 * 
 * @author Merrill Hall
 * @version 1.0
 */
public class InvalidTemperatureException extends InvalidTemperatureTypeException {
    /**
     * Default constructor for InvalidTemperatureException objects. It
     * creates an InvalidTemperatureException with a null detail 
     * message.
     */
    public InvalidTemperatureException() {
        super();
    }

    /**
     * Constructor for InvalidTemperatureException objects. It creates
     * an InvalidTemperatureException object with the specified detail 
     * message.
     */
    public InvalidTemperatureException(String message) {
        super(message);
    }
}