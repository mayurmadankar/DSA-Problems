//time complexity -O(n*2^n) : n- no. of element , 2^n- element add or not add into backtrack
//space complexity-O(n) : to store the element into the array
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result,new ArrayList<>(),nums,0);
        return result;
    }
    public void backTrack(List<List<Integer>> result, List<Integer> temp , int[] nums,int start){
        result.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backTrack(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}