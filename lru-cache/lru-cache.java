class LRUCache {
    
    static class Node{
        Node prev;
        Node next;
        int val;
        int key;
    }
    int capacity;
    int size;
    Node root;
    Node last;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            if(node==last){
                return node.val;
            }
            if(node.prev!=null){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }else{
                root = node.next;
                root.prev = null;
            }
        }else return -1;
        if(last!=null){
            last.next = node;
            node.prev = last;
        }else{
            root = node;
        }
        last = node;
        // order();
        return node.val;
    }
    
    public void put(int key, int value) {
        
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            if(node==last){
                node.val = value;
                return;
            }
            if(node.prev!=null){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }else{
                root = node.next;
                root.prev = null;
            }
        }else{
            if(size==capacity){
                map.remove(root.key);
                root = root.next;
                if(root!=null)
                    root.prev = null;
                else last = null;
            }else{
                size++;
            }
            node = new Node();
            node.next = null;
            node.key = key;
            map.put(key, node);
        }
        node.val = value;
        if(last!=null){
            last.next = node;
            node.prev = last;
        }else{
            root = node;
        }
        last = node;
        // if(key==13)
        
    }
    void order(){
        Node i = root;
        while(i!=null){
            System.out.print(i.key);
            i = i.next;
        }
        System.out.println();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */