class Solution {
    public int numTrees(int n) {
        int p2=n*2;
        long i=1;
        long j=n+1;
        long c=1;
        while(j<=p2){
            c=(c*j)/i;
            i++;
            j++;
        }
        c/=(n+1);
        return (int) c;
    }
} 