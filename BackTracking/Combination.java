//time complexity -o(C(n,k)) where C(n,k) is the binomial coefficient "n choose k"
//space complexity -O(k) for the recursive stack and combination list
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result , new ArrayList<>(),n,k,1);
        return result;
    }
    public void backTrack(List<List<Integer>> result,List<Integer> current, int n,int k,int start){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=n;i++){
            current.add(i);
            backTrack(result,current,n,k,i+1);
            current.remove(current.size()-1);
        }
    }
}