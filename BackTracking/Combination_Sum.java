//time complexity -O(2^n)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,target,new ArrayList<>(),0,result);
        return result;
    }
    public void backtrack(int[] candidates,int target,List<Integer> current,int start,List<List<Integer>> result){
       if(target==0){
        result.add(new ArrayList<>(current));
        return;
       }
       for(int i=start;i<candidates.length;i++){
        if(candidates[i]>target) continue;
         current.add(candidates[i]);
         backtrack(candidates,target-candidates[i],current,i,result);
         current.remove(current.size()-1);
       }
    }
}
 