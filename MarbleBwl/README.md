🔹 Explanation of the Approach

    Start from the last bowl (Nth bowl) and check if there is space (less than 9 marbles).

    If full, move to (N-1)th bowl and check for space.

    If a bowl is found with space, increment its count and reset all later bowls to 0.

    If all bowls are full, return 0.

🔹 Example Walkthrough
Input:

5
3 5 9 9 9

Processing:

    Start from 5th bowl (Full: 9) → Check 4th bowl (Full: 9) → Check 3rd bowl (Full: 9) → Check 2nd bowl (Has space: 5 < 9).

    Increase 2nd bowl by 1 → Reset bowls 3, 4, and 5 to 0.

Output:

2

✅ Time Complexity Analysis

    Best case: O(1) (If last bowl is not full).

    Worst case: O(N) (If all bowls are full).

    Overall Complexity: O(N) worst-case.