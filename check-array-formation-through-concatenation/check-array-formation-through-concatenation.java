class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> mapping = new HashMap<>();
        for(int i=0;i<pieces.length;i++){
            mapping.put(pieces[i][0],pieces[i]);
        }
        int[] array = null;
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(array!=null){
                if(index<array.length){
                    if(array[index]!=arr[i])return false;
                    index++;
                    continue;
                }else{
                    array = null;
                }
            }
            if(mapping.containsKey(arr[i])){
                array = mapping.get(arr[i]);
                index=1;
            }else return false;
        }
        return true;
    }
}
