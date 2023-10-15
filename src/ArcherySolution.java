import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ArcherySolution {

    static int[] numbers = new int[1];

    static int simplify(int divisor){
        int count = 0;
        int length = numbers.length;
        boolean isDivisible = true;
        while(true){
            isDivisible = false;
            for(int i = 0; i < length; i++){
                if(numbers[i] % divisor == 0 && !isDivisible){
                    numbers[i] = numbers[i] / divisor;
                    isDivisible = true;
                    count++;
                } else {
                    if(numbers[i] % divisor == 0){
                        numbers[i] = numbers[i] / divisor;
                    }
                }
            }
            if(!isDivisible)
                break;
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        while(testCases > 0){
            int length = Integer.parseInt(reader.readLine());
            numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long commonMultiple = (long)(Math.pow(2, simplify(2)) * Math.pow(3, simplify(3)) * Math.pow(5, simplify(5)));
            HashSet<Integer> distinctNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toCollection(HashSet::new));
            for(int i: distinctNumbers){
                commonMultiple *= i;
            }
            System.out.println(commonMultiple);
            testCases--;
        }
    }
}
