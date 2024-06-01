//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int x = 0;
        int y = 0;
        
        for (char ch : map.keySet()) {
            int frequency = map.get(ch);
            int alphabetPosition = ch - 'a' + 1;
            
            if (frequency % 2 == 0 && alphabetPosition % 2 == 0) {
                x++;
            }
            
            if (frequency % 2 != 0 && alphabetPosition % 2 != 0) {
                y++;
            }
        }
        
        if ((x + y) % 2 == 0) {
            return "EVEN";
        } else {
            return "ODD";
        }
    }
}
