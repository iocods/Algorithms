import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NonConsecutiveBinaryNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int num = scanner.nextInt();

            if (num == 1) {
                System.out.println(1);
                continue;
            }

            Queue<String> q = new LinkedList<>();
            q.add("1");  // Start with "1"

            for (long i = 2; i <= num; i++) {
                String s = q.poll();

                q.add(s + "0");

                if (s.charAt(s.length() - 1) != '1') {
                    q.add(s + "1");
                }
            }

            System.out.println(q.peek());
        }

        scanner.close();
    }
}
