//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // Edge case: If the array has fewer than 2 elements, return an empty list
        if (arr.length < 2) {
            return new ArrayList<>();
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Initialize pointers
        int left = 0;
        int right = arr.length - 1;
        
        // Variables to track the closest sum and the corresponding pair
        int closestSum = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        
        // Iterate using the two-pointer technique
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // Check if this sum is closer to the target
            if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                closestSum = sum;
                result = new ArrayList<>();
                result.add(arr[left]);
                result.add(arr[right]);
            }
            // If the sum is the same, but the absolute difference is greater, update the result
            else if (Math.abs(sum - target) == Math.abs(closestSum - target)) {
                if (Math.abs(arr[left] - arr[right]) > Math.abs(result.get(0) - result.get(1))) {
                    result = new ArrayList<>();
                    result.add(arr[left]);
                    result.add(arr[right]);
                }
            }
            
            // Move the pointers based on the sum
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
}
