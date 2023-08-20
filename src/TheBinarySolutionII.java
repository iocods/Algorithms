import java.util.ArrayList;

public class TheBinarySolutionII {
    public static void main(String[] args){
        ArrayList<Integer> fibonacciSum = new ArrayList<>();
        int initialValue = 1000;
        int value = 0;
        int count = 0;
        long sum = 0;
        int j = 0;
        for(int i = initialValue; i > 0; i--){
            value = i;
            while(value >= 0){
                if(value == 2) {
                    sum += 10;
                    break;
                }
                if(value == 1){
                    sum += 1;
                    break;
                }
                if(value == 3){
                    sum += 100;
                    break;
                }
                fibonacciSum = getFibonacciSum(value);
                count = fibonacciSum.size() - 1;
                int steps = 0;
                if(count - 1 < 0) {
                    break;
                }
                else
                    steps = fibonacciSum.get(count - 1) + 1;
                sum += Long.parseLong(Integer.toBinaryString((int)Math.pow(2, count)));
                value = value - steps;
            }
            System.out.println("Binary Number: " + sum);
            sum = 0;
            count = 0;
        }
    }
    static ArrayList<Integer> getFibonacciSum(int x){
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
