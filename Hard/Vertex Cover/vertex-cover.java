//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static int min;
    static void solve(int index, int bits, int n, int m, int edges[][]){
        if(index > n){
            for(int i = 0; i < m; i++) if(!((1 << (edges[i][0] - 1) & bits) != 0 || (1 << (edges[i][1] - 1) & bits) != 0)) return;
            min = Math.min(min, Integer.bitCount(bits));
            return ;
        }
        solve(index + 1, bits, n, m, edges);
        solve(index + 1, bits | 1 << (index - 1), n, m, edges);
    }
    public static int vertexCover(int n, int m, int[][] edges) {
        min = Integer.MAX_VALUE;
        solve(1, 0, n, m, edges);
        return min;
    }
}
        
