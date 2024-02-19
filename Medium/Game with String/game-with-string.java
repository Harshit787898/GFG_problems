//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
       HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.offer(entry.getValue());
        }
        while(k!=0){
            int temp=pq.poll();
            if(temp>1){
                pq.add(temp-1);
            }
            k--;
        }
        int ans=0;
        while(!pq.isEmpty()){
            int temp=pq.poll();
            ans+=temp*temp;
        }
        return ans;
        
    }
}