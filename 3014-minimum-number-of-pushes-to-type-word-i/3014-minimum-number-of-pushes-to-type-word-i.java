class Solution {
    public int minimumPushes(String word) {
        int harsh = 0;

        for(int i=0; i<word.length(); i++){
            harsh += i/8 +1;
        }
        return harsh;
    }
}