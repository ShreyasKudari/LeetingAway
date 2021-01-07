class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> unique = new HashMap<>();
        int len = 0;
        int max = 0;
        int start = 0;
        for(int i = 0;i<s.length();i++){
            if(unique.containsKey(s.charAt(i))){
                if(unique.get(s.charAt(i))>=start){
                    int dup_pos = unique.get(s.charAt(i));
                    len-=dup_pos+1-start;
                    start = unique.get(s.charAt(i))+1;  
                }  
            }
            unique.put(s.charAt(i), i);
            len++;
            max = Math.max(len,max);
        }
        return max;
    }
}
