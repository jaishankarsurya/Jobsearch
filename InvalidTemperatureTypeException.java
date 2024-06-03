/**
 * InvalidTemperatureTypeException is an exception that gets thrown if
 * a user tried to create a Temperature object using an invalid temperature
 * type.
 * 
 * @author Merrill Hall
 * @version 1.0
 */
public class InvalidTemperatureTypeException extends Exception {
    /**
     * Default constructor for InvalidTemperatureTypeException objects. It
     * creates an InvalidTemperatureTypeException with a null detail 
     * message.
     */
    public InvalidTemperatureTypeException() {
        super();
    }

    /**
     * Constructor for InvalidTemperatureTypeException objects. It creates
     * an InvalidTemperatureTypeException object with the specified detail 
     * message.
     */
    public InvalidTemperatureTypeException(String message) {
        super(message);
    }
}