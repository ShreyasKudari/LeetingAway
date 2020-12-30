class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> chars = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            chars.put(tasks[i],chars.getOrDefault(tasks[i],0)+1);
        }
        Integer[] array = new Integer[chars.size()];
        int count = 0;
        for(Character ch: chars.keySet()){
            array[count] = chars.get(ch);
            count++;
        }
        Arrays.sort(array, Collections.reverseOrder());
        
        int free_slots = (array[0]-1)*n;
        int i = 1;
        while(free_slots>0 && i<array.length){
            free_slots-=Math.min(array[0]-1,array[i]);
            i++;
        }
        free_slots=free_slots<0?0:free_slots;
        
        return free_slots+tasks.length;
    }
}
