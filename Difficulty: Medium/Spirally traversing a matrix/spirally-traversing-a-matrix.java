//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        int l=0;
        int r=mat[0].length-1;
        int t=0;
        int b=mat.length-1;
        if(mat.length ==0 || mat[0].length ==0) return ans;
        while(l<=r&&t<=b){
            for(int i=l;i<=r;i++){
                ans.add(mat[t][i]);
            }
            t++;
            for(int i=t;i<=b;i++){
                ans.add(mat[i][r]);
            }
            r--;
            if(t<=b){
                for(int i=r;i>=l;i--){
                    ans.add(mat[b][i]);
                }
                b--;
            }
            if(l<=r){
                for(int i=b;i>=t;i--){
                    ans.add(mat[i][l]);
                }
                l++;
            }
        }
        return ans;
    }
}
