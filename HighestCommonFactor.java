/**
 * Java program to find the highest common factor for a given array of intergers
 */

public class HighestCommonFactor {

    public int findHCF(int x, int y) {  //Euclid's methods
        
        if(x == 0)   //If x is zero then greatest common divisor of both will be y
            return y;

        return findHCF(y % x, x);   //if not 0 assign x to y and x becomes the remainder of y/x and check if it's 0 
    }
    
    public int highestCommonFactor(int[] numbers) {
        int result = numbers[0]; //stores the first value
        
        for(int i = 1; i < numbers.length; i++) 
            result = new HighestCommonFactor().findHCF(numbers[i], result);

        return result;
    }

    public static void main(String[] args) {
        //should make this array come from a list
        //handle empty array
        int numArray[] = {2, 4, 6, 8, 16};
        System.out.println(new HighestCommonFactor().highestCommonFactor(numArray)); //calls and prints the highest common factor
    }
}