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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode head = null;
        while(l1!=null && l2!=null){
            int val = l1.val<l2.val?l1.val:l2.val;
            if(head!=null){
                head.next = new ListNode(val);
                head = head.next;
            }else
            {head = new ListNode(val);
             root = head;
            }
            if(l1.val<l2.val)l1=l1.next;
            else l2=l2.next;
        }
        while(l1!=null){
            if(head!=null){
                head.next = new ListNode(l1.val);
                head = head.next;
            }else
              {head = new ListNode(l1.val);
             root = head;
            }
            l1 = l1.next;
        }
        while(l2!=null){
            if(head!=null){
                head.next = new ListNode(l2.val);
                head = head.next;
            }else
               {head = new ListNode(l2.val);
             root = head;
                }
            l2 = l2.next;
        }
        return root;
    }
}
