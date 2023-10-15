import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class HackerearthArcherySolution {
    static int length = 0;
    static int[] numbers;
    static boolean isPrime(int number){
        if(number == 2 || number == 3 || number == 5)
            return true;
        return !(number % 2 == 0 || number % 3 == 0 || number % 5 == 0);
    }

    static int findMax(int[] numbers){
        int max = 0;
        int length = numbers.length;
        for(int i = 0; i < length; i++){
            if(numbers[i] > max)
                max = numbers[i];
        }
        return max;
    }

    static boolean foundMultiple(int currentMultiple){
        int length = numbers.length;
        for(int i = 0; i < length; i++){
            if(currentMultiple % numbers[i] != 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder("");
        int commonMultiple;
        ArrayList<Integer> nonPrimeNumbers;
        while(testCases > 0){
            commonMultiple = 1;
            nonPrimeNumbers = new ArrayList<Integer>();
            length = Integer.parseInt(reader.readLine());
            numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < length; i++){
                if(isPrime(numbers[i]))
                    commonMultiple *= numbers[i];
                else
                    nonPrimeNumbers.add(numbers[i]);
            }
            numbers = nonPrimeNumbers.stream().mapToInt(Integer::intValue).toArray();
            int max = findMax(numbers);
            System.out.println("Max value : " + max);
            int i = 1;
            while(!foundMultiple(max * i))
                i++;
            commonMultiple *= (max * i);
            builder.append(commonMultiple).append('\n');
            testCases--;
        }
        writer.write(builder.toString());
        writer.flush();
    }
}
