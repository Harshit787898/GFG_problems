//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int count = 0;
        int diameterSquared = 4 * r * r;
        for (int w = 1; w <= 2 * r; w++) {
            for (int h = 1; h <= 2 * r; h++) {
                if (w * w + h * h <= diameterSquared) {
                    count++;
                }
            }
        }
        return count;
    }
};