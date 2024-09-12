//time complexity-O(N log N + M log M + M)
//space complexity-O(1)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m=g.length;
        int n=s.length;
        int l=0;
        int r=0;
        Arrays.sort(g);
        Arrays.sort(s);

        while(l<n&&r<m){
            if(g[r]<=s[l]){
                r++;
            }
            l++;
        }
        return r;       
    }
}