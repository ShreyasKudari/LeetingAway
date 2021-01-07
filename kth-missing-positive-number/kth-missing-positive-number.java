class Solution {
    public int findKthPositive(int[] arr, int k) {
        int integer = 1;
        int ans=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=integer){
                while(arr[i]!=integer && k>0){
                    ans = integer;
                    integer++;
                    k--;
                }
                if(k==0)return ans;
            }
            integer++;
        }
        if(k>0) integer+=(k-1);
        return integer;
    }
}
