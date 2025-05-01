import java.util.*;
public class RingElection {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter number of processes in the ring: ");
       int n = sc.nextInt();
       int[] processes = new int[n];
       System.out.println("Enter process IDs:");
       for (int i = 0; i < n; i++) {
           processes[i] = sc.nextInt();
       }
       System.out.print("Enter the process ID that initiates the election: ");
       int initiator = sc.nextInt();
       List<Integer> election = new ArrayList<>();
       int index = -1;
       for (int i = 0; i < n; i++) {
           if (processes[i] == initiator) {
               index = i;
               break;
           }
       }
       System.out.println("\nElection message passing in ring:");
       for (int i = 0; i < n; i++) {
           int idx = (index + i) % n;
           election.add(processes[idx]);
           System.out.println("Process " + processes[idx] + " passes message.");
       }
       int coordinator = Collections.max(election);
       System.out.println("\nProcess " + coordinator + " is elected as new coordinator.");
       sc.close();
   }
}
