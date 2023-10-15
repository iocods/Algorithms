import java.util.Arrays;
import java.util.Scanner;

public class FindingMexWithStringBuilder {
    static boolean[] isFound = new boolean[200001];
    static int findMex(int startIndex){
        for(int i = startIndex; i < isFound.length; i++){
            if(!isFound[i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        scanner.nextLine();
        String numbers = scanner.nextLine();
        int[] number = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int initialMex = 0;
        for(int i = 0; i < number.length; i++){
            isFound[number[i]] = true;
            if(initialMex == number[i]) {
                initialMex = findMex(initialMex);
            }
            builder.append(initialMex).append(' ');
        }
        System.out.println(builder);
    }
}