
/**
Assignment 5, Main.java
Moment 5: Mathematical Methods

1. Print label/itro for radius and height.
2. Read input as radius and height until input is "q", check if integer, continue if so with only 
   positive numbers. If input is "q", end inputreading and continue. Ignore other inputs.
  3. Calculate basesurface area, mantlesurface area and volume with input values as one or more radius 
     and height.
  4. Print radius and height, as well as results from calculations.
5. Print label/intro for fractions.
6. Read input as nominator and denominator until input is "q", check if integer, continue if so with 
   only positive numbers. If input is "q", end inputreading and quit program. Ignore other inputs.
  7. Using arrays, shorten the faction (nominator and denominator) into whole numbers and the rest as 
     a new fraction.
  8. Print nominator and denominator and what it equals after shortening next to the original fraction. 

 
@author Liza Danielsson, lizdan-6
*/

import java.util.Scanner;
import java.util.Locale;

public class Main 
{

  private static Scanner userInput = new Scanner(System.in);

  public static void main(String[] args) 
  {
      // Initiate/declare variables for main method.
    final int VALUE_IF_Q = -1;
    int radius;
    int height;
    float baseSurfaceArea;
    float mantleSurfaceArea;
    float volumeOfCone;
    int numerator;
    int denominator;
    int[] arrayForFractionOutput = new int[3];

      // Print label for area/volym.
    System.out.printf("-----------------------------------" + "%n# Test av area och " + "volymmetoderna"
                      + "%n-----------------------------------%n");

      // Loop, at least once, while true (while there is no break).
    do 
    {
        // Invoke method "input" to get and save value to radius and height.
        // If radius or height is q, break the loop and continue program.
      radius = input();
      if (radius == VALUE_IF_Q) 
      {
        break;
      }
      
      height = input();
      if (height == VALUE_IF_Q) 
      {
        break;
      }

        // Print radius and height.
      System.out.printf("%nr = " + radius + "  h = " + height + "%n");

        // Invoke method "area" for calculating area of base surface.
        // Print the result.
      baseSurfaceArea = area(radius);
      System.out.printf(Locale.US, "Basytans area: %14.2f%n", baseSurfaceArea);

        // Invoke method "area" for calculating area of mantle surface.
        // Print the result.
      mantleSurfaceArea = area(radius, height);
      System.out.printf(Locale.US, "Mantelytans area: %11.2f%n", mantleSurfaceArea);

        // Invoke method "volume" for calculating volume of cone.
        // Print the result.
      volumeOfCone = volume(radius, height);
      System.out.printf(Locale.US, "Volym: %22.2f%n", volumeOfCone);

    } while (true);

    // Print label for fractions.
    System.out.printf("-----------------------------------" + "%n# Test av bråktalsmetoderna"
                      + "%n-----------------------------------%n");



    
      // Loop, at least once, while true (while there is no break).
    do 
    {
        // Invoke method "input" to get and save value for numerator and denominator.
      numerator = input();
      if (numerator == VALUE_IF_Q) 
      {
        break;
      }

      denominator = input();
      if (denominator == VALUE_IF_Q) 
      {
        break;
      }

        // Print numerator and denominator.
      System.out.printf(numerator + "/" + denominator);

        // Invoke method "fraction" to shorten the fraction/s
        //and save array returned from method to "arrayForFractionOutput".
      arrayForFractionOutput = fraction(numerator, denominator);

        // Print result from shortning of fraction by invoking method "printFraction".
      System.out.printf(" = ");
      printFraction(arrayForFractionOutput);
      System.out.printf("%n");

    } while (true);
  }


  
  /**
   * Method that takes an integer as an argument, calculates the area of the base
   * surface of a cone and returns the result as a float.
   */
  public static float area(int radius) 
  {
    final int EXPONENT_TWO = 2;
    double baseSurfaceArea;

    baseSurfaceArea = Math.PI * Math.pow((double) radius, EXPONENT_TWO);
    
    return (float) baseSurfaceArea;
  }


  
  /**
   * Method that takes two integers as arguments, calculates the area of the
   * mantle surface, and then returns the result as a float.
   */
  public static float area(int radius, int height) 
  {
    float hypotenuse;
    float mantleSurfaceArea;

    // Invoke method that calculates the hypotenuse, which is required to...
    // calculate the mantle surface area.
    hypotenuse = pythagoras(radius, height);

    mantleSurfaceArea = (float) Math.PI * (float) radius * hypotenuse;
    
    return mantleSurfaceArea;
  }


  
  /**
   * Method that retrieves two integers, calculates the hypotenuse via the
   * Pythagorean theorem, and returns the result as a float.
   */
  public static float pythagoras(int sideA, int sideB) 
  {
    final int EXPONENT_TWO = 2;
    double hypotenuseSquareTwo;
    double hypotenuseResult;

    hypotenuseSquareTwo = (Math.pow((double) sideA, EXPONENT_TWO)) + (Math.pow((double) sideB, EXPONENT_TWO));

    hypotenuseResult = Math.sqrt(hypotenuseSquareTwo);
    
    return (float) hypotenuseResult;
  }


  
  /**
   * Method that takes two integers, calculates the volume of the cone, and
   * returns the result as a float.
   */
  public static float volume(int radius, int height) 
  {
    final int EXPONENT_TWO = 2;
    final int NUMERATOR_THREE = 3;
    double volumeOfConeResult;

    volumeOfConeResult = (Math.PI * Math.pow((double) radius, EXPONENT_TWO) * height) / NUMERATOR_THREE;
    
    return (float) volumeOfConeResult;
  }


  
  /**
   * Method for fractions. Method that retrieves the numerator and denominator
   * (two integers), shortens the fraction, and returns the result in an integer
   * array.
   */
  public static int[] fraction(int nominator, int denominator) 
  {
    final int DENOMINATOR_OR_NOMINATOR_ZERO = 0;
    final int[] FRACTION_ARRAY_IF_ZERO = { 0, 0, 0 };
    int[] fractionArray = new int[3];
    int greatestCommonDivider;

      //If denominator is 0, return undefinied value.
    if (denominator == DENOMINATOR_OR_NOMINATOR_ZERO) 
    {
      return null; 
    } 
      //If nominator is 0, return an array with three zeros.
    else if (nominator == DENOMINATOR_OR_NOMINATOR_ZERO) 
    {
      return FRACTION_ARRAY_IF_ZERO;
    } 
      //Otherwise divide nominator and denominator to get any whole values from 
      //fraction and save the rest fraction as two numbers in place 2 and 3 in array
    else 
    {
      fractionArray[0] = nominator / denominator;
      fractionArray[1] = nominator % denominator;
      fractionArray[2] = denominator;

        // Invoke method "gcd" to find greatest common divider to shorten the rest fraction with.
      greatestCommonDivider = gcd(fractionArray[1], fractionArray[2]);
      fractionArray[1] = fractionArray[1] / greatestCommonDivider;
      fractionArray[2] = fractionArray[2] / greatestCommonDivider;

      return fractionArray;
    }
  }


  
  /**
   * Method that takes the rest fraction from place 2 and 3 in array, calculates the greatest common
   * devider and returns it as an integer.
   */
  public static int gcd(int a, int b) 
  {
    int temporaryInt;
    final int ZERO = 0;
    int c;

    if (a < b) 
    {
      temporaryInt = a;
      a = b;
      b = temporaryInt;
    }

    while (b != ZERO) 
    {
      c = a % b;
      a = b;
      b = c;
    }

    return a;
  }


  
  /**
   * Method that retrieves and prints an array of three integers, the
   * array is printed as a whole integer and the rest as a fraction.
   * The method prints the numbers depending on if, and if so, which ones are zero.
   */
  public static void printFraction(int[] parts) 
  {
    final int ZERO = 0;

    if (parts == null) 
    {
      System.out.print("\"Error\"");
    } 
    else if (parts[2] == ZERO) 
    {
      System.out.printf(Integer.toString(ZERO));
    } 
    else if (parts[0] == ZERO) 
    {
      System.out.printf(parts[1] + "/" + parts[2]);
    } 
    else if (parts[1] == ZERO) 
    {
      System.out.printf(Integer.toString(parts[0]));
    } 
    else 
    {
      System.out.printf(parts[0] + " " + parts[1] + "/" + parts[2]);
    }
  }


  
  /**
   * Method that when invoked takes the input from the global scanner and checks in a loop if input is
   * an integer, if so, it change any negative values into positive, breaks and returns it. 
   * otherwise if input i q, it breaks and returns -1, last if input is anything else, it will ignore.
   */
  public static int input() {
    int valueOfInput = 0;
    final int VALUE_IF_Q = -1;

    while (true) 
    {
      if (userInput.hasNextInt()) 
      {
        valueOfInput = userInput.nextInt();
        valueOfInput = Math.abs(valueOfInput);
        break;
      } 
      else if (userInput.next().equalsIgnoreCase("q")) 
      {
        valueOfInput = VALUE_IF_Q;
        break;
      } 
      else 
      {
        System.out.print("");
      }
    }
    return valueOfInput;
  }
}
