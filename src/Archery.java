import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Archery {
    static int[] numbers = new int[0];
    static int length = 0;
    static int findMax(int[] numbers){
        int max = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > max)
                max = numbers[i];
        }
        return max;
    }
    static boolean foundMultiple(int currentMultiple){
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

        while(testCases > 0){
            length = Integer.parseInt(reader.readLine());
            numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxNumber = findMax(numbers);
            System.out.println("Max value = " + maxNumber);
            int i = 1;
            while(!foundMultiple(maxNumber * i)) {
                i++;
            }
            int lowestMultiple = maxNumber * i;
            builder.append(lowestMultiple).append('\n');
            testCases--;
        }
        writer.write(builder.toString());
        writer.flush();
    }
}