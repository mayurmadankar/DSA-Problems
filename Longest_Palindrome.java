class Solution {
    public int longestPalindrome(String s) {
        Map<Character , Integer> count = new HashMap<>();

        for(char c : s.toCharArray()){
            count.put(c , count.getOrDefault(c,0)+1);
        }
        int result =0;
        boolean odd_found = false;

        for(int c : count.values()){
            if(c%2==0){
                result+=c;
            }else{
                odd_found=true;
                result+=c-1;
            }
        }
        if(odd_found){
            result+=1;
        }
        return result;
    }
}