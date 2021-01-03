class Solution {
    public int countArrangement(int n) {
        int[] used = new int[n];
        return recurse(0, used);
    }
    public int recurse(int index, int[] used){
        if(index==used.length)return 1;
        int sum=0;
        for(int i=1;i<=used.length;i++){
            if(used[i-1]==1)continue;
            used[i-1]=1;
            if(i%(index+1)==0 || (index+1)%i==0)
                sum+=recurse(index+1, used);
            used[i-1]=0;
        }
        return sum;
    }
}
