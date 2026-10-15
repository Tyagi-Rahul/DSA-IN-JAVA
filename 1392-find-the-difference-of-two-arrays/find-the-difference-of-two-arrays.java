class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();



        for(int x : set1){
            if(!set2.contains(x)){
                a.add(x);
            }
        }

        for(int x : set2){
            if(!set1.contains(x)){
                b.add(x);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(a);
        ans.add(b);
        return ans;
    }
}