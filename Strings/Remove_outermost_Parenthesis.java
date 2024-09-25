//tc-O(n)
//sc-O(n)
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level=0;

        for(char c : s.toCharArray()){
            if(c=='('){
                if(level>0){
                    sb.append(c);
                }
                level++;
            }else if(c==')'){
                level--;
                if(level>0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}