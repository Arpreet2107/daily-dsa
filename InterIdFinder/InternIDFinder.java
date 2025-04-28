
import java.util.Scanner;


public class InternIDFinder {
    public static int findInternNumber(int targetID) {
        for (int intern = 1; intern <= 24; intern++) {
            int id = 5000 * intern;  // ID on Day 1
            int day = 1;

            // Generate IDs for upcoming days
            while (id <= targetID) {
                if (id == targetID) {
                    return intern; // Found the intern number
                }
                day++;
                id += 5000 + (intern - 1); // Update ID based on given rule
            }
        }
        return -1; // If ID doesn't match any intern
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetID = sc.nextInt(); // Input the target intern ID

        int internNumber = findInternNumber(targetID);
        System.out.println(internNumber);
        sc.close();
    }
}
