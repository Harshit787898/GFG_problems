//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        long sum = 0;
        while (a <= b && (b - a) <= 100000) {
            sum += factors(a);
            a++;
        }
        return sum;
    }
    public static long factors(long num) {
        // code here
        if (num <= 1) return 0;

        long factorSum = 0;

        // Handle the factor 2 separately
        while (num % 2 == 0) {
            factorSum++;
            num /= 2;
        }

        // Check odd factors starting from 3
        for (long i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0 && num > 0) {
                factorSum++;
                num /= i;
            }
        }

        // If num is still greater than 2, it's a prime factor
        if (num > 2) {
            factorSum++;
        }

        return factorSum;
    }
}
        
