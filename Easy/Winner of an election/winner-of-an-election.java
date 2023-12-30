//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();

        for (String name : arr) {
            if (countMap.containsKey(name)) {
                countMap.put(name, countMap.get(name) + 1);
            } else {
                countMap.put(name, 1);
            }
        }

        String winner = null;
        int maxCount = 0;

        for (String name : countMap.keySet()) {
            int count = countMap.get(name);
            if (count > maxCount || (count == maxCount && name.compareTo(winner) < 0)) {
                maxCount = count;
                winner = name;
            }
        }

        String[] result = {winner, String.valueOf(maxCount)};
        return result;
    }
}

