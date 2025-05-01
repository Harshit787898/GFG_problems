//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        if(n==0){
            return new ArrayList<>();
        }
        if(n==1){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(1);
            return temp;
        }
        ArrayList<Integer> res=new ArrayList<>();
        int ans=1;
        res.add(ans);
        for(int i=1;i<n;i++){
            ans=ans*(n-i);
            ans=ans/i;
            res.add(ans);
        }
        return res;
    }
}