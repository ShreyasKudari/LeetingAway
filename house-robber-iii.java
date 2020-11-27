/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    HashMap<TreeNode, Integer> memo_include = new HashMap<>();
    public int rob(TreeNode root) {
        //backtracking problem
       return Math.max(recurse(root,0),recurse(root,1));
    }
    public int recurse(TreeNode node, int adj){
        if(node==null)return 0; //use first if including current, use last if not including current 
        if(adj==1){
            if(!memo.containsKey(node)){
                int left = recurse(node.left, 0);
                int right = recurse(node.right, 0);
                memo.put(node,left+right);
            }
            return memo.get(node);
        }else{
            if(!memo_include.containsKey(node)){
                int left_include = recurse(node.left, 1);
                int right_include = recurse(node.right, 1);
                memo_include.put(node,node.val+left_include+right_include);
            }
             if(!memo.containsKey(node)){
                int left_exclude = recurse(node.left, 0);
                int right_exclude = recurse(node.right,0);
                memo.put(node, left_exclude+right_exclude);
             }
            return Math.max(memo.get(node), memo_include.get(node));
        }
        
        
    }
}
