//time complexity -O(1) because the board is fixed in size
//space complexity -O(1) because the element stored in hashse is fixed and independent of inpu size
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                int current_val=board[i][j];

                //check the value in current index is empty for filled
                if(current_val!='.'){
                    //contruct the unique val for row ,col,sub boxes
                    String rowKey = "row"+i+current_val;
                    String colKey = "col"+j+current_val;
                    String boxKey = "box"+(i/3)+(j/3)+current_val;

                    // If any identifier is already in the set, it's invalid
                    if(!seen.add(rowKey)||!seen.add(colKey)||!seen.add(boxKey)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}