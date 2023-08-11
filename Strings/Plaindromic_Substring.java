//time complexity - 2n-1 *n
//space complexity -O(1)
class Solution {
    public int countSubstrings(String s) {
        if(s.length()==0){return 0;}
        int n = s.length();
        int res=0;
        char[] c = s.toCharArray();

        for(int i=0 ; i<n ; i++){
            //for odd length take start and end is i and i respectively
            //for even length take start and end as 1 and i+1 respectively 
            res+=isPalindrome(c , i , i);
            res+=isPalindrome(c , i , i+1);
        }
        return res;
    }
    public int isPalindrome(char [] c , int start , int end){
        int count=0;
        while(start>=0 && end<c.length && c[start--]==c[end++]){
            count++;
        }
        return count;
    }
}