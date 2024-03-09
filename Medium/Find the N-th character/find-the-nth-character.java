//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        int l=s.length();
        if(s.length()%2==0){
            l=l/2;
        }
        else{
            l=l/2+1;
        }
        while(r!=0){
            String temp="";
            for(int i=0;i<l;i++){
                if(s.charAt(i)=='0')
                temp+="01";
                else{
                    temp+="10";
                }
            }
            s=temp;
            r--;
        }
        return s.charAt(n);
    }
}