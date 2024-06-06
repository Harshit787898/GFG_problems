//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int[] arr, int length) {
        long initialScore = 0; // Initial rotational sum
        long arraySum = 0; // Sum of all elements in the array
        
        // Calculate the initial rotational sum and the total sum of the array
        for (int i = 0; i < length; i++) {
            initialScore += (long)i * arr[i];
            arraySum += (long)arr[i];
        }
        
        long maxRotationalSum = initialScore; // Initialize with the initial rotational sum
        long currentScore = initialScore;
    
        // Calculate rotational sums by moving elements and updating the score
        for (int i = 1; i < length; i++) {
            currentScore = currentScore - arraySum + (long)length * arr[i - 1];
            maxRotationalSum = Math.max(maxRotationalSum, currentScore);
        }
        
        return maxRotationalSum; // Return the maximum rotational sum found
    }
}