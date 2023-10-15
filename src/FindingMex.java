import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingMex {
    static boolean[] isFound = new boolean[200001];
    static int findMex(int startIndex){
        for(int i = startIndex; i < isFound.length; i++){
            if(!isFound[i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        scanner.readLine();
        String numbers = scanner.readLine();
        StringBuilder builder = new StringBuilder("");
        int[] number = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int initialMex = 0;
        int found = 0;
        for(int i = 0; i < number.length; i++){
            found = number[i];
            isFound[found] = true;
            if(initialMex == found) {
                initialMex = findMex(initialMex);
            }
            builder.append(initialMex).append(" ");
        }
    }
}
