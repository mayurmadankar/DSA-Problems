class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        int start=0;
        int end =0;

        for(int i=0 ; i<s.length() ; i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);
            int len = Math.max(odd , even);

            if(len>end-start){
                //for odd len (5)-> i=3 , start =i-2 , end =i+2;
                //for even len (6) -> i=3 , satrt = i-2 , end = i+3;
                start =i-(len-1)/2;
                end =i+(len)/2;
            }
        }
        //get string from start to end and end+1 is becaude substring get upto last secong value to get last value also we add end+1;
        return s.substring(start , end+1);
    }
    private static int expand(String s, int left , int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}