class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length-1;
        
        while(top+1<bot){
            int mid = (top+bot)/2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                top = mid;
            }else{
                bot = mid;
            }
        }
        int left = 0;
        int right = matrix[top].length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[top][mid]==target)return true;
            else if(matrix[top][mid]<target)left = mid+1;
            else right = mid-1;
        }
        left = 0;
        right = matrix[bot].length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[bot][mid]==target)return true;
            else if(matrix[bot][mid]<target)left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}