class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> a = new HashSet<>();
        Set<String> re = new HashSet<>();

        for(int i=0;i<=s.length()-10;i++){
            String su = s.substring(i,i+10);

            if(!a.add(su)){
                re.add(su);
            }
        }
        return new ArrayList<>(re);
    }
}