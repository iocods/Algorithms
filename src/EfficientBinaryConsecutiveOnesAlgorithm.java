import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class EfficientBinaryConsecutiveOnesAlgorithm {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> fibonacciSum; // A List variable that is used to hold the sum of every possible series
        long value = 0;                  // value represents the nth term of the series.
        int count = 0;
        BigInteger sum = new BigInteger("0"); // A type of object that is used to hold arbitrary large numbers
        int j = 0;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); // A class for reading input
        long testCases = Long.parseLong(stdin.readLine()); // Get the number of TestCases
        StringBuilder printer = new StringBuilder();
        while (j < testCases) {
            value =  Long.parseLong(stdin.readLine());
            while (value >= 0) {
                if(value <= 3){
                    if (value == 2) {
                        sum = sum.add(BigInteger.valueOf(10));
                        break;
                    }
                    if (value == 1) {
                        sum = sum.add(BigInteger.valueOf(1));
                        break;
                    }
                    if (value == 3) {
                        sum = sum.add(BigInteger.valueOf(100));
                        break;
                    }
                }
                fibonacciSum = getFibonacciSum(value);
                count = fibonacciSum.size() - 1;
                int steps = 0;
                if (count - 1 < 0) {
                    break;
                }
                else
                    steps = fibonacciSum.get(count - 1) + 1;
                StringBuilder builder = new StringBuilder();
                builder.append(Long.toBinaryString((long)Math.pow(2, count)));
                BigInteger adding = new BigInteger(builder.toString());
                sum = sum.add(adding);
                value = value - steps;
            }
            printer.append(sum).append('\n');
            sum = BigInteger.valueOf(0);
            count = 0;
            j++;
        }
        System.out.println(printer);
    }

    /**
     * A simple method that is used to compute the different sum of fibonacci series
     * @param x is passed as parameter to ensure that only required sum is calculated
     * @return a list of all the sum in all the possible series
     */
    static ArrayList<Integer> getFibonacciSum(long x){
        ArrayList<Integer> fibonacciSum = new ArrayList<>();
        int previousNumber = 0;
        int nextNumber = 1;
        int fibonacciNumber = 0;
        int sum = 1;
        fibonacciSum.add(sum);
        while(sum < x){
            fibonacciNumber = previousNumber + nextNumber;
            sum += fibonacciNumber;
            previousNumber = nextNumber;
            nextNumber = fibonacciNumber;
            fibonacciSum.add(sum);
        }
        return fibonacciSum;
    }
}