class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        int[][] solution = new int[intervals.length][2];
        if(solution.length==0 || solution.length==1)return intervals;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>end){
                solution[count][0]=start;
                solution[count][1]=end;
                start = intervals[i][0];
                end = intervals[i][1];
                count++;
            }else{
                end = Math.max(intervals[i][1], end);
            }
        }
        solution[count][0] = start;
        solution[count][1] = end;
        int[][] final_sol = new int[count+1][2];
        for(int i=0;i<=count;i++){
            final_sol[i][0] = solution[i][0];
            final_sol[i][1] = solution[i][1];
        }
        return final_sol;
    }
}
