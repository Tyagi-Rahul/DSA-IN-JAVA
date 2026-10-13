class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return ans(nums1,nums2);
    }

    public static double ans(int[]arr1,int[]arr2){
        int m=arr1.length;
        int n=arr2.length;
        int[] merge = new int[m+n];
        for(int i=0;i<(m+n);i++){
            if(i<m){
                merge[i]=arr1[i];
            }
            else{
                merge[i]=arr2[i-m];
            }
        }
        int lo=0 , hi=merge.length-1;
        int mid=lo+(hi-lo)/2;
        double median=0.0;
        int l=merge.length;
        Arrays.sort(merge);
        if(l%2==0){
            median = (merge[mid]+merge[mid+1])/2.0;
        }
        else{
            median=merge[mid];
        }

        return median;
    }
}