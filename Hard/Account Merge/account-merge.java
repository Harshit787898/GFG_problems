//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
  static void merge(ArrayList<HashSet> a,ArrayList<HashSet> res,
                      List<List<String>> accounts,int j){
     
      if(a.size()==1){
          fill(accounts,a.get(0),j);
      }
      else{
          HashSet<String> uwu=new HashSet<>();
          for(HashSet<String> u:a){
              for(String gg:u){
                  uwu.add(gg);
              }
              res.remove(u);
          }
          fill(accounts,uwu,j);
          res.add(uwu);   
      }
      
  }     
  
  static void fill(List<List<String>> accounts,HashSet<String> y,int j){
      
      for(int i=1;i<accounts.get(j).size();i++){
          if(!y.contains(accounts.get(j).get(i))){
              y.add(accounts.get(j).get(i));
          }
      }
      
  }
    
  static List<List<String>> accountsMerge(List<List<String>> accounts){
      
      List<List<String>> res=new ArrayList<List<String>>();
      HashMap<String,ArrayList<HashSet>> mp=new HashMap<>();
      
      for(int i=0;i<accounts.size();i++){
          boolean flag = false;
          String name=accounts.get(i).get(0);
          
          if(mp.containsKey(name)){
              ArrayList<HashSet> x=mp.get(name);
              ArrayList<HashSet> merged=new ArrayList<>();
              
              for(int j=0;j<x.size();j++){
                  HashSet<String> y=x.get(j);
                  for(int k=1;k<accounts.get(i).size();k++){
                      if(y.contains(accounts.get(i).get(k))){
                          merged.add(y);
                          flag=true;
                      }
                  }
              }
              if(flag==false){
                  HashSet<String> z=new HashSet<>();
                  for(int k=1;k<accounts.get(i).size();k++){
                      z.add(accounts.get(i).get(k));
                  }
                  x.add(z);
              }
              else{
                  merge(merged,x,accounts,i);
              }
          }
          
          else{
              ArrayList<HashSet> temp=new ArrayList<HashSet>();
              HashSet<String> s=new HashSet<>();
              for(int u=1;u<accounts.get(i).size();u++){
                  s.add(accounts.get(i).get(u));
              }
              temp.add(s);
              mp.put(name,temp);
          }
      }
      
      for(String name : mp.keySet()){
          ArrayList<HashSet> curr=mp.get(name);
          for(int i=0;i<curr.size();i++){
              List<String> hm=new ArrayList<String>();
              hm.add(name);
              HashSet<String> set=curr.get(i);
              for(String s : set){
                  hm.add(s);
              }
              Collections.sort(hm);
              res.add(hm);
          }
      }
      
      return res;
      
  }
}