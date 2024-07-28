class Solution {
    public int strStr(String haystack, String needle) {
        int  hays = haystack.length();
        int need = needle.length();

        for(int i=0 ;i<haystack.length()-needle.length()+1 ; i++){
            if(haystack.substring(i,needle.length()+i).equals(needle)){
                return i;
            }
        }
        return -1;

        
    }
}