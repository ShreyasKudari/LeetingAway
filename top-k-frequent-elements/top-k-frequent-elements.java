class Solution {
    class Node{
        Node(int number){
            this.number = number;
            this.freq = 1;
        }
        int number;
        int freq;
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> order = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return b.freq - a.freq;
            }
        });
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new Node(nums[i]));
                order.add(map.get(nums[i]));
            }else{
                map.get(nums[i]).freq++;
                order.remove(map.get(nums[i]));
                order.add(map.get(nums[i]));
            }
        }
        int[] answer = new int[k];
        for(int i=0;i<k;i++){
            answer[i] = order.poll().number;
        }
        return answer;
    }
}
​
