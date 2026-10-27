class Solution {
    public String[] createGrid(int m, int n) {
        String[][]grid=new String[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==n-1)grid[i][j]=".";
                else grid[i][j]="#";
            }
        }
        String[]ans=new String[m];
        int index=0;
        for(String[] row:grid){
            StringBuilder cur=new StringBuilder();
            for(String str:row){
                cur.append(str);
            }
            ans[index++]=cur.toString();
        }
        return ans;
    }
}