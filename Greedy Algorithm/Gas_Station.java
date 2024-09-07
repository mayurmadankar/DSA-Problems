//time complexity-O(n)
//space complexity-O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff=0;
        int n=gas.length;
        int fuel=0;
        int index=0;

        for(int i=0;i<n;i++){
            int diff =gas[i]-cost[i];
            totalDiff+=diff;
            fuel+=diff;
            
            if(fuel<0){
                index=i+1;
                fuel=0;
            }
        }
        return (totalDiff>=0)?index:-1;
    }
}