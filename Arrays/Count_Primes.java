class Solution {
    public int countPrimes(int n) {
      if(n<=2){
        return 0;
      }
      boolean[] composites=new boolean[n];
      int limit =(int)Math.sqrt(n);

      for(int i=2;i<=limit;i++){
        //Mark all the multiples of i to true
        //The index to be flipped to true is i*i
        for(int j=i*i;j<n;j+=i){
            composites[j]=true;
        }
      }
      int count=0;
      for(int i=2;i<n;i++){
        if(composites[i]==false){
            count++;
        }
      }
      return count;
    }
}