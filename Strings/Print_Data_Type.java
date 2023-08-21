public class Solution {
    public static int dataTypes(String type) {
        // Write your code here
         switch (type) {
            case "Integer":
                return 4;
            case "Double":
                return 8;
            case "Float":
                return 4;
            case "Character":
                return 1; // Java's char uses 2 bytes
            case "Long":
                return 8;
            default:
                return -1; // Or some other value to indicate an unknown type
        }
    }
}