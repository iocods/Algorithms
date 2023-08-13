import java.io.*;
import java.util.*;


public class EfficientArrayTramAlgorithm {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        int numberOfStations = stdin.nextInt();
        int start = stdin.nextInt();
        int finish = stdin.nextInt();
        long[] ticketCost = new long[numberOfStations];
        for(int i = 0; i < ticketCost.length; i++)
            ticketCost[i] = stdin.nextInt();
        long minimumCost = solve(numberOfStations, start, finish, ticketCost);
        System.out.println(minimumCost);
    }
    static long solve(int N, int start, int finish, long[] Ticket_cost){
        if(finish < start) {
            int temp = start;
            start = finish;
            finish = temp;
        }
        long sumCosts = Arrays.stream(Ticket_cost).sum();
        long cost = 0;
        for(int i = start - 1; i < finish - 1; i++)
            cost += Ticket_cost[i];
        if((sumCosts - cost) < cost)
            cost = sumCosts - cost;
        return cost;
    }
}