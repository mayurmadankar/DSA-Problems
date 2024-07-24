//tc-O(n logn)
//sc-O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
//edge case
        if(intervals.length<=1){
            return intervals;
        }
//inbuilt function to sort array
        Arrays.sort(intervals , Comparator.comparingInt(i->i[0]));

        List<int[]> result = new ArrayList<>();
//make new arraylist
        int [] newinterval = intervals[0];
        result.add(newinterval);

// checking the 2nd interger of 1sr array and 1st int of 2nd array
        for(int interval[] : intervals){
            if(interval[0] <= newinterval[1]){
                newinterval[1]=Math.max(interval[1] , newinterval[1]);
            }else{
//making new array in result 
                newinterval=interval;
                result.add(newinterval);
            }
        } 
        return result.toArray(new int[result.size()][]);
    }
}