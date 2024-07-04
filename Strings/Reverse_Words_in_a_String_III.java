//time complexity -o(n)
//space complexity -o(n)
class Solution {
    public String reverseWords(String s) {
        String []words=s.split(" ");
        
        StringBuilder result = new StringBuilder();

        for(String word:words){
                StringBuilder reverse = new StringBuilder(word).reverse();

                result.append(reverse).append(" ");
        } 
        return result.toString().trim();
    }
}