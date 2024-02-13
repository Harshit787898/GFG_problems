//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean possible(int n,int mid,int k,int[]a){
        int c=1;int pos=a[0];
        for(int i=0;i<n;i++){
            if(a[i]-pos>=mid){
                c++;
                if(c==k)
                return true;
                pos=a[i];
            }
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int i=1;
        int j=stalls[n-1];
        int ans=0;
        while(i<=j){
            int mid=(i+j)>>1;
            if(possible(n,mid,k,stalls)){
                ans=Math.max(ans,mid);
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;
    }
}