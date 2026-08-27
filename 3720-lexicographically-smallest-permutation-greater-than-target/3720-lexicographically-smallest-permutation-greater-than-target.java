class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count =new int [26];
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }   
        for(int i =n-1;i>=0;i--){
            int[] tempCount = count.clone();
            boolean possible =true;
            for(int j=0;j<i;j++){
                char ch =target.charAt(j);
                if(tempCount[ch -'a']>0){
                    tempCount[ch -'a']--;
                }else{
                    possible =false;
                    break;
                }
            }
            if(!possible)continue;
            char targetChar =target.charAt(i);
            for(int c =targetChar -'a'+1;c<26;c++){
                if(tempCount[c]>0){
                    StringBuilder sb = new StringBuilder();
                    sb.append(target,0,i);
                    sb.append((char)('a'+c));
                    tempCount[c]--;
                    for(int k =0; k<26;k++){
                        while (tempCount[k]>0){
                            sb.append((char)('a'+k));
                            tempCount[k]--;
                        }
                    }
                    return sb.toString();
                }
            }
        } 
        return "";  
    }
}