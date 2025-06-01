class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1[i].length;j++){
                if(map.containsKey(mat1[i][j])){
                    map.put(mat1[i][j],map.get(mat1[i][j])+1);
                }else{
                    map.put(mat1[i][j],1);
                }
            }
        }
        int ans=0;
        for(int i=0;i<mat2.length;i++){
            for(int j=0;j<mat2[i].length;j++){
                int req=x-mat2[i][j];
                if(map.containsKey(req)){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}