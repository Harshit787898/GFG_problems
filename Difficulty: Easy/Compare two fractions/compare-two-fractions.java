//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
    String arr[]=str.split(", ",0);
   String n1[]=arr[0].split("/",0);
   String n2[]=arr[1].split("/",0);
   double a=Double.parseDouble(n1[0])/Double.parseDouble(n1[1]);
      double b=Double.parseDouble(n2[0])/Double.parseDouble(n2[1]);
      
      if(a>b)return arr[0];
      
      if(a==b)return "equal";
      
      return arr[1];
      
    }
}
