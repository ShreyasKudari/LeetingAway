class Solution {
    public int hIndex(int[] citations) {
       int l=0;
       int r=citations.length-1;
        int mid;
        int hindex=0;
        while(l<=r){
            mid=(l+r)/2;
            if(citations[mid]<citations.length-mid){
                l=mid+1;
            }
            else if(citations[mid]>citations.length-mid){
                hindex=citations.length-mid;
                r=mid-1;
            }
            else if(citations[mid]==citations.length-mid){
                hindex=citations.length-mid;
                break;
            }
        }
        return hindex;
    }
}
