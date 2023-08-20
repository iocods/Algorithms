
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationAlgoSolution {
    /**
     * A function that search for the max value in a given range of numbers
     * @param numbers is the given array that is passed into the function
     * @param start specifies the first index in the given range of numbers
     * @param end specifies the last index of the given range of numbers
     * @return max: which represents the maximum value in the specified range of numbers
     */
    static int findMax(int[] numbers, int start, int end) {
        int max = numbers[start];
        for (int i = start + 1; i < end; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }


    public static void main(String[] args) throws Exception{
        Map<Integer, Integer> startIndexValue = new HashMap<>(); // Created Two variable of type map to keep track
        Map<Integer, Integer> endIndexValue = new HashMap<>();   // of index checked so far and to keep record of the
                                                                 // corresponding max value
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // for reading from the input source
        String input = reader.readLine(); // read a line from the input stream
        String[] inputs = input.split(" ");
        int arraySize = Integer.parseInt(inputs[0]);// compute the value of the array's size and the number of test cases from the array above
        int testCases = Integer.parseInt(inputs[1]);
        startIndexValue.put(1, 0);  // put initial values into the map objects in the case of a start index value of 1 a value of zero was assigned and
        endIndexValue.put(arraySize, 0);  // in the case where the end index value is equal to array size place a value of zero in the
        int startIndex = 0;
        int endIndex = 0;
        int tests = 0;
        int startMaxValue = 0;
        int endMaxValue = 0;
        int[] numbers = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder builder = new StringBuilder("");
        //while the tests carried so far is less than the number of testcases execute the while loop
        while(tests < testCases){
            inputs = reader.readLine().split(" ");
            startIndex = Integer.parseInt(inputs[0]);
            endIndex = Integer.parseInt(inputs[1]);
            if(startIndexValue.containsKey(startIndex)){
                startMaxValue = startIndexValue.get(startIndex);
                if(endIndexValue.containsKey(endIndex))
                    endMaxValue = endIndexValue.get(endIndex);
                else {
                    endMaxValue = findMax(numbers, endIndex, arraySize);
                    endIndexValue.put(endIndex, endMaxValue);
                }
            }
            else if(endIndexValue.containsKey(endIndex)){
                endMaxValue = endIndexValue.get(endIndex);
                if(startIndexValue.containsKey(startIndex))
                    startMaxValue = startIndexValue.get(startIndex);
                else {
                    startMaxValue = findMax(numbers, 0, startIndex-1);
                    startIndexValue.put(startIndex, startMaxValue);
                }
            }
            else{
                startMaxValue = findMax(numbers, 0, startIndex-1);
                endMaxValue = findMax(numbers, endIndex, arraySize);
                startIndexValue.put(startIndex, startMaxValue);
                endIndexValue.put(endIndex, endMaxValue);
            }
            builder.append(Math.max(endMaxValue, startMaxValue)).append('\n'); // append the max value and a new line character to the StringBuilder object
            tests++; // Increase the number of test.
        }
        System.out.println(builder); // Print the value to the console.
    }
}
