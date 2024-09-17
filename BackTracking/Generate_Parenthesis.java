class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result,"",0,0,n);
        return result;
    }
    public void backTrack(List<String> result,String current,int open,int close,int max){
        if(current.length()==max*2){
            result.add(current);
            return;
        }
        if(open<max){
            backTrack(result,current+"(",open+1,close,max);
        }
        if(close<open){
            backTrack(result,current+")",open,close+1,max);
        }
    }
}