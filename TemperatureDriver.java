import java.util.Scanner;
/**
 * TemperatureDriver runs and tests the Temperature class. 
 * 
 * @author Surya Jaishankar
 * @version 1.0
 */

public class TemperatureDriver{
    
    public static void main(String[] args){
        double inputTemperature = 0.0; 
        Scanner keyInput = new Scanner(System.in); 
        Temperature t1; 
        String temperatureType = " ";
        
        System.out.print("Enter a temperature type (C for Celsius, " + " F for Fahrenheit, K for Kelvin):");
        temperatureType = keyInput.next();
        System.out.print("Enter a temperature: "); 
        inputTemperature = keyInput.nextDouble();
        t1 = new Temperature(temperatureType, inputTemperature);
        
        if(temperatureType.equalsIgnoreCase("F")){
            System.out.println("You entered " + inputTemperature + " degrees Fahrenheit"); 
            System.out.println("Which is " + t1.getDegreesCelsius() + " degrees Celsius"); 
            System.out.println("And " + t1.getDegreesKelvin() + " degrees Kelvin");
        }
        else if(temperatureType.equalsIgnoreCase("C")){
            System.out.println("You entered " + inputTemperature + " degrees Celsius"); 
            System.out.println("Which is " + t1.getDegreesFahrenheit() + " degrees Fahrenheit"); 
            System.out.println("And " + t1.getDegreesKelvin() + "degrees Kelvin"); 
        }
        else if(temperatureType.equalsIgnoreCase("K")){
            System.out.println("You enetered " + inputTemperature + " degrees Kelvin"); 
            System.out.println("Which is " + t1.getDegreesCelsius() + " degrees Celsius"); 
            System.out.println("And " + t1.getDegreesFahrenheit() + " degrees Fahrenheit");
        }
        else {
            System.out.println("You entered an invalid temperature type: "); 
            System.out.println("It must be Celsius, Fahrenheit, or Kelvin.Please try the program again.");
            
        }
    }
}