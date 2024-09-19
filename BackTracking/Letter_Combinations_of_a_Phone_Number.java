//time complexity-O(3^n . 4^m)
class Solution {
    private static final String[] KEYPAD={
        "",    // 0 (no mapping)
        "",    // 1 (no mapping)
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz" // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null||digits.length()==0){
            return result;
        }
        backTrack(result,new StringBuilder(),digits,0);
        return result;
    }
    public static void backTrack(List<String> result,StringBuilder Combination,String digits,int index){
        if(index==digits.length()){
            result.add(Combination.toString());
            return;
        }
        String letters = KEYPAD[digits.charAt(index)-'0'];
        
        for(char letter : letters.toCharArray()){
            Combination.append(letter);
            backTrack(result,Combination,digits,index+1);
            Combination.deleteCharAt(Combination.length()-1);
        }
    }
}