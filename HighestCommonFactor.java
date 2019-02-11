/**
 * Java program to find the highest common factor for a given array of intergers
 */

public class HighestCommonFactor {
    /**
     * Euclid's methods - if x is zero then greatest common divisor of both x and y will be y, if not assign
     * x to y and x becomes the remainder(mod) of y/x and check if it's 0
     * @param x,y the two numbers to compare for highest common factor
     * @return the HCF of two numbers
     */
    public int findHCF(int x, int y) { 
        
        if(x == 0)
            return y;

        return findHCF(y % x, x); 
    }

    /**
     * @param numbers the array of numbers that we finding the HCF
     * @return highest common factor for all the numbers in the array
     */
    public int highestCommonFactor(int[] numbers) {
        int result = numbers[0];
        
        for(int i = 1; i < numbers.length; i++) 
            result = new HighestCommonFactor().findHCF(numbers[i], result);

        return result;
    }

    public static void main(String[] args) throws Exception {
         try {
            int numArray[] = {50, 15, 5, 25, 85};
            System.out.println(new HighestCommonFactor().highestCommonFactor(numArray)); 
        } catch (Exception e) {
            System.out.println("The array can't be empty");
        }
    }
}