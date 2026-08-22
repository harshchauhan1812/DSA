class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int p=1;
        for(int i=n;i>0;i/=10){
            sum+=i%10;
            p*=i%10;
        }
        return n%(sum+p)==0;
    }
}