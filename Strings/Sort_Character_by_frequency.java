//time complexity - O(n)
//space complexity -O(n)

Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c,0)+1);
        }
        List<Character>[] bucket = new List[s.length()+1];
        for(Character key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency]==null){
                bucket[frequency]=new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder result = new StringBuilder();
        for(int i=bucket.length-1 ; i>=0 ;i--){
            if(bucket[i]!=null){
                for(char c : bucket[i]){
                    for(int j=0 ; j<map.get(c) ;i++){
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();