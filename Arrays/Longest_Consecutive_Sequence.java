//tc-O(n)
//sc-O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength=0;
        Map<Integer,Boolean> map=new HashMap<>();
        for(int num:nums){
            map.put(num,false);
        }
        for(int num:nums){
            int currentLength=1;

            // Skip the number if it is already part of a sequence
           if(map.get(num)){
            continue;
           }
            // Mark the current number as part of a sequence
            map.put(num,true);

            //next num
            int nextNum=num+1;
            while(map.containsKey(nextNum)&&map.get(nextNum)==false){
                currentLength++;
                map.put(nextNum,true);
                nextNum++;
            }
            //prev num
            int prevNum=num-1;
            while(map.containsKey(prevNum)&&map.get(prevNum)==false){
                currentLength++;
                map.put(prevNum,true);
                prevNum--;
            }
            longestLength=Math.max(currentLength,longestLength);
        }
        return longestLength;
    }
}