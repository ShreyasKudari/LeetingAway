/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
​
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode or_ptr = original;
        TreeNode cl_ptr = cloned;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<TreeNode> clones = new Stack<>();
        while(or_ptr.val != target.val){
           if(or_ptr.left!=null){
               nodes.push(or_ptr.left);
               clones.push(cl_ptr.left);
           }
           if(or_ptr.right!=null){
               nodes.push(or_ptr.right);
               clones.push(cl_ptr.right);
           }
           or_ptr = nodes.pop();
           cl_ptr = clones.pop();
        }
        return cl_ptr;
    }
}
