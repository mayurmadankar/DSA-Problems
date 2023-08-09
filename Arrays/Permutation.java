class Solution {
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> resultList = new ArrayList<>();

      backtrack(resultList , new ArrayList<>() , nums);
      return resultList;  
    }
    private void backtrack(List<List<Integer>> resultList , ArrayList<Integer> tempList , int[] nums){
        if(tempList.size()==nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for(int number : nums){
            // contains duplicate number then dont select 
            if(tempList.contains(number)){
                continue;
            }
            // adding number to templist
            tempList.add(number);
            // backtrack
            backtrack(resultList , tempList , nums);
            // remove the number which we add on templist from path
            tempList.remove(tempList.size()-1);
        }
    }
}