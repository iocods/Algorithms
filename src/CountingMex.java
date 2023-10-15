import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CountingMex {
    static boolean[] isFound = new boolean[200001];
    static int[] mexCounts = new int[10];
    static int arraySize = 0;
    static int findMex(int startIndex){
        for(int i = startIndex; i < 200001; i++){
            if(!isFound[i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder("");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());
        while(testCases > 0) {
            arraySize = Integer.parseInt(reader.readLine());
            mexCounts = new int[arraySize + 1];
            String numbers = reader.readLine();
            int[] number = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
            int initialMex = 0;
            int found = 0;
            int count = 0;

            for (int i = 1; i < number.length; i++) {
                found = number[i];
                isFound[found] = true;
                if (initialMex == found) {
                    mexCounts[initialMex] = count;
                    initialMex = findMex(initialMex);
                    count = 0;
                }
                count++;
            }
            mexCounts[initialMex] = count;
            initialMex = 0;
            found = 0;
            count = 0;
            isFound = new boolean[200001];
            int j = 0;
            for (int i = number.length - 1; i >= 1; i--) {
                found = number[i];
                isFound[found] = true;
                if (initialMex == found) {
                    mexCounts[initialMex] = count + mexCounts[initialMex];
                    initialMex = findMex(initialMex);
                    count = 0;
                }
                count++;
            }
            mexCounts[initialMex] = count + mexCounts[initialMex];
            testCases--;
            isFound = new boolean[200001];
            int length = mexCounts.length;
            for(int i = 1; i < length; i++)
                System.out.print(mexCounts[i] + " ");
            System.out.println();
        }
    }
}