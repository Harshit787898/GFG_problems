//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n=mat.length;
        int arr[]=new int[n*n];
        int pos=0;
       for(int i=0;i<n;i++){
           if(i%2==0){
               for(int j=i,k=0;j>=0;j--,k++){
                   arr[pos++]=mat[j][k];
               }
           }else{
                for(int j=0,k=i;j<=i;j++,k--){
                    arr[pos++]=mat[j][k];
                }
           }
       }
       for(int i=1;i<n;i++){
           if(n%2==0){
                if(i%2==1){
                    for(int j=n-1,k=i;j>=i;j--,k++){
                        arr[pos++]=mat[j][k];
                    }
                }else{
                    for(int j=i,k=n-1;j<n;j++,k--){
                        arr[pos++]=mat[j][k];
                    }
                }
           }else{
               if(i%2==1){
                   for(int j=i,k=n-1;j<n;j++,k--){
                       arr[pos++]=mat[j][k];
                   }
               }else{
                   for(int j=n-1,k=i;j>=i;j--,k++){
                       arr[pos++]=mat[j][k];
                   }
               }
           }
       }
       return arr;
    }
}