class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(c==')'&& !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}