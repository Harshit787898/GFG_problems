//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Product {
        int price;
        int quantity;

        public Product(int price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }

    public static int buyMaximumProducts(int n, int budget, int[] prices) {
        ArrayList<Product> productList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            productList.add(new Product(prices[i], i + 1));
        }

        Collections.sort(productList, (a, b) -> {
            if (a.price - b.price == 0) {
                return b.quantity - a.quantity;
            }
            return a.price - b.price;
        });

        int totalQuantity = 0;

        for (Product product : productList) {
            int cost = product.price;
            int availableQuantity = product.quantity;

            if (cost * availableQuantity <= budget) {
                totalQuantity += availableQuantity;
                budget -= cost * availableQuantity;
            } else {
                totalQuantity += budget / cost;
                budget -= cost * (budget / cost);
            }
        }

        return totalQuantity;
    }
}
        
