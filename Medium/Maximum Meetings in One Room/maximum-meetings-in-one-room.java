//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Pair{
        int start;
        int end;
        int index;
        Pair(int s,int e,int i){
            this.start=s;
            this.end=e;
            this.index=i;
        }
    }
    public static ArrayList<Integer> maxMeetings(int n, int[] s, int[] f) {
        Pair [] p=new Pair[n];
        for(int i=0;i<n;i++){
            p[i]=new Pair(s[i],f[i],i+1);
        }
        Arrays.sort(p,(a,b)->a.end-b.end);
        ArrayList<Integer> ans=new ArrayList<>();
        int end=-1;
        for(int i=0;i<n;i++){
            if(p[i].start>end){
                ans.add(p[i].index);
                end=p[i].end;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
        
