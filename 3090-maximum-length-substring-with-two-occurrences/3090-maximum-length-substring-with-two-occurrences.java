class Solution
{
    public int maximumLengthSubstring(String s)
    {
        int[] count = new int[26];
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            int index = c - 'a';
            count[index]++;

            while (count[index] > 2)
            {
                char leftChar = s.charAt(left);
                int leftIndex = leftChar - 'a';
                count[leftIndex]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}