class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> LeftParenStack = new Stack<>();
        Stack<Integer> StarStack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(c=='('){
                LeftParenStack.push(i);
            }else if(c=='*'){
                StarStack.push(i);
            }else{
                if(!LeftParenStack.isEmpty()){
                    LeftParenStack.pop();
                }else if(!StarStack.isEmpty()){
                    StarStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(!LeftParenStack.isEmpty()&&!StarStack.isEmpty()){
            if(LeftParenStack.peek()<StarStack.peek()){
                LeftParenStack.pop();
                StarStack.pop();
            }else{
                return false;
            }
        }
        return LeftParenStack.isEmpty();       
    }
}