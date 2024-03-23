//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int ans[] = obj.Series(n);
            for (int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    int[] Series(int n) {
        // code here
        int a=0;
        int b=1;
        int ar[]=new int[n+1];
        ar[0]=0;
        ar[1]=1;
        for(int i=2;i<=n;i++){
            ar[i]=(a+b)%(1000000007);
            a=b;
            b=ar[i];
        }
        return ar;
    }
}