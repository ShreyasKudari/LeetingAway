class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int odd_flag = 0;
        for(Integer i: map.values()){
            if(i%2!=0 && odd_flag==0) odd_flag=1;
            else if(i%2==0)continue;
            else return false;
        }
        return true;
    }
}
