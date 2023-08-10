//time compllexity - O(n*k)
//space complexity - O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      if(strs==null || strs.length==0){
          return new ArrayList<>();
      }  
      HashMap<String, List<String>> frequencyMap = new HashMap<>();
      for(String str : strs){
          //call getFrequency method
          String frequency = getfrequency(str);

          if(frequencyMap.containsKey(frequency)){
              frequencyMap.get(frequency).add(str);
          }else{
              List<String> strList = new ArrayList<>();
              strList.add(str);
              frequencyMap.put(frequency , strList);
          }
      }
      return new ArrayList<>(frequencyMap.values());
    }
    private static String getfrequency(String str){
        //frequency buckets
        int freq[] = new int[26];

        for(char c : str.toCharArray()){
            freq[c-'a']++;
        }
        //string builder to append value of single string
        StringBuilder frequencyString = new StringBuilder();
        char c ='a';
        for(int i :freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
}