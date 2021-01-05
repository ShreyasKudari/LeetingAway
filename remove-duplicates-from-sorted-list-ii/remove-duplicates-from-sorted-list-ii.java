/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> dups = new HashSet<>();
        ListNode root = head;
        ListNode prev = null;
        while(root!=null){
            if(prev!=null && prev.val==root.val && !dups.contains(root.val))
                dups.add(root.val);
            prev=root;
            root = root.next;
        }
        root = head;
        prev = null;
        
        while(root!=null){
            if(dups.contains(root.val) && prev == null){
                head = head.next;
                root = head;
            }
            else if(dups.contains(root.val)){
                root = root.next;
            }else if(prev==null){
                prev = root;
                root = root.next;
            }else{
                prev.next = root;
                prev = root;
                root = root.next;
            }            
        }
        if(prev!=null)
            prev.next = root;
        return head;
    }
}
