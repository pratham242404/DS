package election;

import java.util.Scanner;

public class BullyElection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int[] processes = new int[n];
        boolean[] alive = new boolean[n];
        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            processes[i] = sc.nextInt();
            alive[i] = true;
        }
        System.out.print("Enter the process ID that detects coordinator failure: ");
        int initiator = sc.nextInt();
        System.out.println("\nElection initiated by process " + initiator);
        int newCoordinator = initiator;
        for (int i = 0; i < n; i++) {
            if (processes[i] > initiator && alive[i]) {
                System.out.println("Process " + initiator + " sends election to " + processes[i]);
                System.out.println("Process " + processes[i] + " replies OK");
                newCoordinator = Math.max(newCoordinator, processes[i]);
            }
        }
        System.out.println("\nProcess " + newCoordinator + " becomes the new coordinator.");
        sc.close();
    }
}
