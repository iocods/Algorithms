
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EfficientPermutationAlgo {
    static int[] start;
    static int[] end;
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
        Map<Integer, Integer> startIndexValue = new HashMap<>();
        Map<Integer, Integer> endIndexValue = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputs = input.split(" ");
        int arraySize = Integer.parseInt(inputs[0]);
        int testCases = Integer.parseInt(inputs[1]);
        startIndexValue.put(1, 0);
        endIndexValue.put(arraySize, 0);
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
        end = new int[arraySize];
        start = new int[arraySize];
        for(int i = 0; i < testCases; i++){
            inputs = reader.readLine().split(" ");
            start[i] = Integer.parseInt(inputs[0]);
            end[i] = Integer.parseInt(inputs[1]);
        }
        while(tests < testCases){
            startIndex = start[tests];
            endIndex = end[tests];
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
            if(startMaxValue > endMaxValue)
                builder.append(startMaxValue).append('\n');
            else
                builder.append(endMaxValue).append('\n');
            tests++;
        }
        System.out.println(builder);
    }
}
