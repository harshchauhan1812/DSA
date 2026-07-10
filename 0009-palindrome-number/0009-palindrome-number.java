class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int num=0;
        while(x>0){
            num = num*10;
            num =num + (x%10);
            x = x/10;
        }
        if(temp==num){
            return true;
        }
        return false;
    }
}