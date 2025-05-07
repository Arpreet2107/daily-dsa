// File: CelebrityProblem.java

public class CelebrityProblem {

    static int MATRIX[][] = {
        {0, 1, 1},
        {0, 0, 1},
        {0, 0, 0}
    };

    // Function to check if a knows b
    static boolean knows(int a, int b) {
        return MATRIX[a][b] == 1;
    }

    // Function to find celebrity
    static int findCelebrity(int n) {
        int a = 0, b = n - 1;

        // Find potential celebrity
        while (a < b) {
            if (knows(a, b)) {
                a++; // a can't be celebrity
            } else {
                b--; // b can't be celebrity
            }
        }

        int candidate = a;

        // Verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1; // Not a celebrity
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int n = 3;
        int celebrity = findCelebrity(n);

        if (celebrity == -1) {
            System.out.println("No Celebrity Found");
        } else {
            System.out.println("Celebrity is person " + celebrity);
        }
    }
}
