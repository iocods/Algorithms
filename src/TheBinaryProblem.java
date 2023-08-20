import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheBinaryProblem {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> fibonacciSum;
        long value = 0;
        int count = 0;
        BigInteger sum = new BigInteger("0");
        int j = 0;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of test cases");
        int testCases = Integer.parseInt(stdin.readLine());
        int [] tests = new int[testCases];
        Arrays.fill(tests, 1000000000);
        System.out.println("Testcase : " + testCases);
        StringBuilder printer = new StringBuilder();
        long startTime = System.currentTimeMillis();
        while (j < testCases) {
            value =  tests[j];
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
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
    }
    static ArrayList<Integer> getFibonacciSum(long x){
        ArrayList<Integer> fibonacciSum = new ArrayList<>();
        int previousNumber = 0;
        int nextNumber = 1;
        int fibonacciNumber = 0;
        int sum = 1;
        int count = 0;
        fibonacciSum.add(sum);
        while(sum < x){
            fibonacciNumber = previousNumber + nextNumber;
            sum += fibonacciNumber;
            previousNumber = nextNumber;
            nextNumber = fibonacciNumber;
            fibonacciSum.add(sum);
            count++;
        }
        return fibonacciSum;
    }
}
