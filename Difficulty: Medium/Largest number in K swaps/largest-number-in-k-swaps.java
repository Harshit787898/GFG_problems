//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        // code here.
        char arr[]=new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i);
        }
        for(int i=0;i<s.length();i++){
            int id=-1;
            char cu=arr[i];
            for(int j=s.length()-1;j>i;j--){
                char temp=arr[j];
                if(temp>cu){
                    id=j;
                    cu=temp;
                }
            }
            if(id!=-1 && k>0){
                char t=arr[id];
                arr[id]=arr[i];
                arr[i]=t;
                k--;
            }
        }
        String ans="";
        for(int i=0;i<arr.length;i++){
            ans+=arr[i];
        }
        return ans;
    }
}