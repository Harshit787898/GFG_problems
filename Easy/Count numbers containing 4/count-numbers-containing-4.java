//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static boolean isValid(int n){
        while(n!=0){
            int d=n%10;
            if(d==4){
                return true;
            }
            n=n/10;
        }
        return false;
    }
    public static int countNumberswith4(int n) {
        // code here
        int ans=0;
        for(int i=0;i<=n;i++){
            if(isValid(i)){
                ans++;
            }
        }
        return ans;
    }
}
