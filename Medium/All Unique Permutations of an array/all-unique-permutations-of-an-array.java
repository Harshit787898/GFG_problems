//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static void helper(ArrayList<Integer> arr, ArrayList<Integer> current, Set<ArrayList<Integer>> result) {
        if (arr.size() == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            int curr = arr.get(i); 
            if(used.contains(curr)){
                continue;
            }
            ArrayList<Integer> newArr = new ArrayList<>(arr);//after removing curr
            newArr.remove(i);
            current.add(curr);
            used.add(curr);//set to check if list is already present or not
            helper(newArr, current, result);//call
            current.remove(current.size() - 1);//backtrack
        }
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Set<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> current = new ArrayList<>();
        helper(arr, current, result);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(result);
        ans.sort((list1, list2) -> {
            for(int i=0;i<list1.size();i++){
                int cmp=list1.get(i).compareTo(list2.get(i));
                if(cmp!=0){
                    return cmp;
                }
            }
            return 0;
          });
        return ans;
    }
};

