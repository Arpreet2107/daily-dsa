import java.util.Scanner;

public class MarbleBowl {
    public static int findModifiedBowl(int N, int[] bowls) {
        // Start checking from the last bowl (Nth)
        for (int i = N - 1; i >= 0; i--) {
            if (bowls[i] < 9) {
                bowls[i]++;  // Add a marble
                for (int j = i + 1; j < N; j++) {
                    bowls[j] = 0;  // Reset all subsequent bowls
                }
                return i + 1; // Bowl numbers are 1-based
            }
        }
        return 0; // If all bowls are full
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] bowls = new int[N];

        for (int i = 0; i < N; i++) {
            bowls[i] = sc.nextInt();
        }

        System.out.println(findModifiedBowl(N, bowls));
        sc.close();
    }
}
