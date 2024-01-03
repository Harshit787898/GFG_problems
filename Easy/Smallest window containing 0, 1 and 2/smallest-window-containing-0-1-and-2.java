//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int z=0,o=0,t=0,j=0,ans=Integer.MAX_VALUE;
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(c=='0') z++;
            else if(c=='1') o++;
            else if(c=='2') t++;
            if(z>0 && o>0 && t>0) ans=Math.min(ans,S.substring(j,i+1).length());
            while(z>0 && o>0 && t>0){
                if(S.charAt(j)=='0') z--;
                else if(S.charAt(j)=='1') o--;
                else t--;
                j++;
                if(z>0 && o>0 && t>0) ans=Math.min(ans,S.substring(j,i+1).length());
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
};
