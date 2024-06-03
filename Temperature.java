/**
 * Temperature converts temperature from Fahrenheit, Celsius,
 * or Kelvin scale to the other two scales.
 * 
 * @author Merrill Hall 
 * @version 2.0
 */
public class Temperature extends InvalidTemperatureException {
    private double degreesFahrenheit;  // Fahrenheit temperature
    private double degreesCelsius;  // Celsius temperature
    private double degreesKelvin;  // Kelvin temperature

    /**
     * This constructor for Temperature sets the temperature
     * values to the value from degrees, based on the type
     *  
     * @param  type      temperature scale to use
     * @param  degrees   degrees Fahrenheit
     */
    public Temperature(String type, double degrees) {
        if (type.equalsIgnoreCase("C"))
            setDegreesCelsius(degrees);
        else if (type.equalsIgnoreCase("F"))
            setDegreesFahrenheit(degrees);
        else if (type.equalsIgnoreCase("K"))
            setDegreesKelvin(degrees);
    }

    /**
     * The setDegreesFahrenheit method sets the Fahrenheit temperature
     * 
     * @param  degrees The Fahrenheit value to store 
     */
    public void setDegreesFahrenheit(double degrees) {
        degreesFahrenheit = degrees; // set Fahrenheit value
        degreesCelsius    = (degreesFahrenheit - 32.0) * 5.0 / 9.0; // set Celsius value
        degreesKelvin     = degreesCelsius + 273.15; // set Kelvin value
    } 

    /**
     * The setDegreesCelsius method sets the Celsius temperature
     * 
     * @param  degrees The Celsius value to store 
     */
    public void setDegreesCelsius(double degrees) {
        degreesCelsius    = degrees;
        degreesFahrenheit = degreesCelsius * 9.0 / 5.0 + 32.0;
        degreesKelvin     = degreesCelsius + 273.15;
    }

    /**
     * The setDegreesKelvin method sets the Kelvin temperature
     * 
     * @param  degrees The Kelvin value to store 
     */
    public void setDegreesKelvin(double degrees) {
        degreesKelvin     = degrees;
        degreesCelsius    = degreesKelvin - 273.15;
        degreesFahrenheit = degreesCelsius * 9.0 / 5.0 + 32.0;
    }

    /**
     * getDegreesCelsius retrieves the Celsius temperature value
     * 
     * @return a double value containing the Celsius temperature
     */
    public double getDegreesCelsius() {
        return degreesCelsius;
    }

    /**
     * getDegreesKelvin retrieves the Kelvin temperature value
     * 
     * @return a double value containing the Kelvin temperature
     */
    public double getDegreesKelvin() {
        return degreesKelvin;
    }

    /**
     * getDegreesFahrenheit retrieves the Fahrenheit temperature value
     * 
     * @return a double value containing the Fahrenheit temperature
     */
    public double getDegreesFahrenheit() {
        return degreesFahrenheit;
    }
}