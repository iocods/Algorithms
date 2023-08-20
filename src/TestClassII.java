import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestClassII {
    public static void main(String args[] ) throws Exception {
        Scanner stdin = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = stdin.nextInt();
        int i = 1;
        while (i <= numberOfTestCases){
            int arraySize = stdin.nextInt();
            int stepsOfRotation = stdin.nextInt();
            stepsOfRotation = stepsOfRotation % arraySize;
            String lineData = reader.readLine();
            String[] numbers = lineData.split(" ");
            rotateArrayAndPrint(stepsOfRotation, numbers);
            i++;
        }
        reader.close();
        stdin.close();
    }

    static void rotateArrayAndPrint(int steps, String[] numbers) {
        int i = numbers.length - steps;
        StringBuilder builder = new StringBuilder("");
        while(i < numbers.length){
            builder.append(numbers[i]).append(" ");
            i++;
        }
        i = 0;
        int length =  (numbers.length - steps);
        while(i < length){
            builder.append(numbers[i]).append(" ");
            i++;
        }
        System.out.println(builder.toString());
    }
}

