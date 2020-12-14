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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
        recursive(root);
        return moves;
    }
    public int recursive(TreeNode node){
        if(node==null)return 0;
        int left_req = recursive(node.left);
        int right_req = recursive(node.right);
        int diff=left_req+right_req+1-node.val;
        moves+=Math.abs(diff);
        return diff;
    }
}
