//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long ExtractNumber(String sentence) {
        String arr[]=sentence.split(" ");
        long max=-1;
        for(int i=0;i<arr.length;i++){
            boolean flag=false;
            for(int j=0;j<arr[i].length();j++){
                if((arr[i].charAt(j))-'0'==9){
                    flag=false;
                    break;
                }
                else if(Character.isDigit(arr[i].charAt(j)))
                     flag=true;
                else
                     flag=false;
            }
            if(flag){
                max=Math.max(max,Long.parseLong(arr[i]));
            }
        }
        return max;
    }
}