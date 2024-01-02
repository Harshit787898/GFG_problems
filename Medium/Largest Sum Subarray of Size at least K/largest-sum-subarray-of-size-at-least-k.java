//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long sum = 0;
        long max1 = Integer.MIN_VALUE;
        int j = 0;
        long rahee = 0;
        for(int i = 0; i< n;i++)
        {
            sum += a[i];
            
            if(i - j + 1 == k)
            {
                max1 = Math.max(max1,sum);
            }
            else if(i - j + 1 > k)
            {
                rahee += a[j];
                j++;
            
             if(rahee < 0)
            {
               sum -= rahee;
               rahee = 0;
            }
            
            max1 = Math.max(max1,sum);
            }
        }
            return max1;
        }
    }

