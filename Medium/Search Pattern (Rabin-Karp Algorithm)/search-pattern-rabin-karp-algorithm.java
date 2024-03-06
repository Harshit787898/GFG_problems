//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        StringBuilder str=new StringBuilder(text);
        int i=str.indexOf(pattern);
        ArrayList<Integer> ans=new ArrayList<>();
        if(i==-1)
        return new ArrayList<>();
        ans.add(i+1);
        while(i>=0){
            i=str.indexOf(pattern,i+1);
            if(i>=0)
            ans.add(i+1);
        }
        return ans;
    }
}