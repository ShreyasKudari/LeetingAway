class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] merged = new int[position.length][2];
        for(int i=0;i<merged.length;i++){
            merged[i][0] = target-position[i];
            merged[i][1] = speed[i];
        }
        Arrays.sort(merged, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        double time = -1;
        int count = 0;
        for(int i=0;i<merged.length;i++){
                double rel_time = ((double)merged[i][0])/((double)merged[i][1]);
                if(rel_time>time){
                    count++;
                    time = rel_time;
                   
            }
        }
        return count;
    }
}