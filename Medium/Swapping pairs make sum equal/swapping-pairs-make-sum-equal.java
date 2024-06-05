//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    boolean isPresent(long[] arr,long target){
        int l=0,h=arr.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]<target){
                l = mid + 1;
            }else{
                h = mid -1 ;
            }
        }
        
        return false;
    }
    
    long findSwapValues(long a[], int n, long b[], int m) {
        long sum1 = 0;
        long sum2 = 0;
        
        for(long x:a){
            sum1 += x;
        }
        
        for(long y:b){
            sum2 += y;
        }
        
        long diff = Math.abs(sum1-sum2);
        
        //if diff bet sum of arr a & b is odd then return -1 as we cant make equal using above given condition
        if(diff%2!=0){
            return -1;
        }
        //sort array so we can use binary search for searching our target value
        Arrays.sort(a);
        Arrays.sort(b);
        //target is half of diff as we can add half on one side while subtract on other side to make it equal
        long target=diff/2;
        
        if(sum1<sum2){ 
            for(long x:a){
                if(isPresent(b,x+target)){
                    return 1;
                }
            }
        }else{
            for(long y:b){
                if(isPresent(a,y+target)){
                    return 1;
                }
            }
        }
        
        
        return -1;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends