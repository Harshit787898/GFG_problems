//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        long ans=0;
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(xor==k){
                ans+=1;
            }
            if(map.containsKey(xor^k)){
                ans+=map.get(xor^k);
            }
            if(map.containsKey(xor)){
                map.put(xor,map.get(xor)+1);
            }else{
                map.put(xor,1);
            }
        }
        return ans;
    }
}