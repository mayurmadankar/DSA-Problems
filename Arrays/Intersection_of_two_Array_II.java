class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       Map<Integer,Integer> freqMap1=new HashMap<>();

       for(int num:nums1){
        freqMap1.put(num,freqMap1.getOrDefault(num,0)+1);
       }
       List<Integer> ans = new ArrayList<>();
       for(int num:nums2){
        if(freqMap1.containsKey(num)&&freqMap1.get(num)>0){
            ans.add(num);
             freqMap1.put(num,freqMap1.get(num)-1);
        }
       }
       int [] res=new int[ans.size()];
       for(int i=0;i<ans.size();i++){
        res[i]=ans.get(i);
       }
       return res;
    }
}