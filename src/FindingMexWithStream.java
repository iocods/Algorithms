import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class FindingMexWithStream {
    static boolean[] isFound = new boolean[200001];
    static int arraySize = 0;
    static int findMex(int startIndex){
        for(int i = startIndex; i < arraySize; i++){
            if(!isFound[i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder("");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        arraySize = Integer.parseInt(reader.readLine());
        String numbers = reader.readLine();
        int[] number = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int initialMex = 0;
        int found = 0;
        for(int i = 0; i < number.length; i++){
            found = number[i];
            isFound[found] = true;
            if(initialMex == found) {
                initialMex = findMex(initialMex);
            }
            builder.append(initialMex).append(' ');
        }
        try{
            writer.write(builder.toString());
            writer.flush();
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }
}