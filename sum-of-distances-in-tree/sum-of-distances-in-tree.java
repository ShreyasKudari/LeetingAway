class Solution {
          HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        //HashSet<Integer> rootfinder = new HashSet<>();
        int[] subtree_count = new int[N];
        int[] subtree_sum = new int[N];
        for(int i=0;i<edges.length;i++){
            if(!tree.containsKey(edges[i][0])){
                tree.put(edges[i][0],new ArrayList<>());
            }
            if(!tree.containsKey(edges[i][1])){
                tree.put(edges[i][1],new ArrayList<>());
            }
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
            
            //rootfinder.add(edges[i][1]);
        }
        int root=0;
        // for(int i=0; i<N; i++){
        //     if(!rootfinder.contains(i)){
        //         root = i;
        //         break;
        //     }
        // }
       System.out.println(tree);
        HashSet<Integer> visited = new HashSet<>();
        traverse_post(root,subtree_count, subtree_sum, visited);
        for(int i=0;i<N;i++)
           System.out.println(subtree_count[i]);
        visited.clear();
        traverse_pre(root, -1, subtree_count, subtree_sum, N, visited);
        return subtree_sum;
    }
    public void traverse_post(int node, int[] subtree_count, int[] subtree_sum, HashSet<Integer> visited){
        if(tree.get(node)==null)return;
        visited.add(node);
        for(Integer child: tree.get(node)){
            if(visited.contains(child))continue;
            traverse_post(child, subtree_count, subtree_sum, visited);
            subtree_count[node]+=subtree_count[child]+1;
            subtree_sum[node]+=subtree_sum[child]+subtree_count[child]+1;
        }
    }
    public void traverse_pre(int node,int prev, int[] subtree_count, int[] subtree_sum, int N, HashSet<Integer> visited){
        if(visited.contains(node))return;
        visited.add(node);
        if(prev!=-1) 
            subtree_sum[node] = subtree_sum[prev]-subtree_count[node]-1+N-subtree_count[node]-1;
        if(tree.get(node)!=null)
            for(Integer i: tree.get(node)) {
                traverse_pre(i,node,subtree_count, subtree_sum, N, visited);
            }
    }
}
