//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void swap(int[]l,int[]r){
        for(int i=0;i<l.length;i++){
            int t=l[i];
            l[i]=r[i];
            r[i]=t;
        }
    }
    static void rotateby90(int mat[][]) {
        // code here
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat[0].length;j++){
                int t=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=t;
            }
        }
        int i=0;
        int j=mat.length-1;
        while(i<j){
            swap(mat[i],mat[j]);
            i++;
            j--;
        }
    }
}