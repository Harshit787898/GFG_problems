//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        // code here
        List<int[]> spk = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (gallery[i] != -1) {
                spk.add(new int[]{Math.max(0, i - gallery[i]), Math.min(n - 1, i + gallery[i])});
            }
        }

        Collections.sort(spk, (a, b) -> Integer.compare(a[0], b[0]));

        int start = 0;
        int i = 0;
        int ans = 0;

        while (start < n) {
            int maxRight = -1;
            while (i < spk.size()) {
                if (spk.get(i)[0] > start)
                    break;

                maxRight = Math.max(maxRight, spk.get(i)[1]);
                i++;
            }

            if (maxRight < start)
                return -1;

            ans++;
            start = maxRight + 1;
        }

        return ans;


    }
}
