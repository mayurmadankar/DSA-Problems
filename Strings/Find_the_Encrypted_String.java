class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        
        int length=s.length();
        
        for(int i=0;i<length;i++){
            char newChar = s.charAt((i+k)%length);
            sb.append(newChar);
        }
        return sb.toString();
    }
}