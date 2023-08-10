//Time Complexity - O(s+t)
//Space Complexity - O(s+t);

public class Solution {
    public String minWindow(String s , String t){
        if(s.length()==0 || s.length()<t.length()){
            return "";
        }
        HashMap<Character , Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c , map.get(c)+1);
            }else{
                map.put(c , 1);
            }
        }
        int count =0;
        int start =0;
        int minLength =Integer.MAX_VALUE;
        int minleft =0;

        for(int right=0 ; right<s.length() ; right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right) , map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right))>=0){
                    count++;
                }
            }
             while(count==t.length()){
            if(minLength>right-start+1){
                minLength=right-start+1;
                minleft=start;
            }
            //remove
            if(map.containsKey(s.charAt(start))){
                map.put(s.charAt(start) , map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start))>0){
                        count--;
                }
            }
             start++;
          }
        }
        if(minLength>s.length()){return "";}
        return s.substring(minleft , minleft+minLength);
    }
  
}
