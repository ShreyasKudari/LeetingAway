/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
​
class Solution {
    HashMap<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        return recurse(node);
    }
    public Node recurse(Node node){
        if(node==null)return null;
        Node newnode = new Node(node.val);
        visited.put(node.val,newnode);
        for(Node neighbor: node.neighbors){
            if(!visited.containsKey(neighbor.val)){
                newnode.neighbors.add(recurse(neighbor));
            }
            else{
                newnode.neighbors.add(visited.get(neighbor.val));
            }    
        }
        return newnode;
    }
}
