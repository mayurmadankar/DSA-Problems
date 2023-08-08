import java.util.*;

public class HashMapCode{
    static class HashMap<K,V>{//GENERICS
        private class Node{
             K key;
             V value;

             public Node(K key , V value){
                this.key = key;
                this.value = value;
             }
        }
        private int n; // nodes 
        private int N; // buckets size
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        //Initialize empty linkedlist
        public HashMap(){
            this.N =4;
            this.buckets = new LinkedList[4];
            for(int i=0 ; i<4 ; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){//0 - N-1
            int bi = key.hashCode();
            return Math.abs(bi)%N; 
        }
        private int searchInLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];
            int di =0;
            for(int i=0 ; i<ll.size() ; i++){
                if(ll.get(i).key== key){
                    return i;//di
                }
            }
            return -1;
        }
        // to create new bucket array fo double size to avoid mesh
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0 ; i<N*2 ; i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0 ; i<oldBuckets.length ; i++){
                LinkedList<Node> ll = oldBuckets[i];

                for(int j=0 ; j<ll.size() ; j++){
                    Node node =ll.get(j);
                    put(node.key , node.value);
                }
            }
        }
        // simply put the element in bucket
        public void put(K key , V value){
            int bi = hashFunction(key);
            int di = searchInLL(key ,bi);//data index 

            if(di==-1){//key doesnt exist
                buckets[bi].add(new Node(key , value));
                n++;
            }else{//key exist
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }
        //checcked contain key
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key ,bi);//data index 

            if(di==-1){//key doesnt exist
               return false;
            }else{//key exist
                return true;
            }
        }
        //remove key
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key ,bi);//data index 

            if(di==-1){//key doesnt exist
                return null;
            }else{//key exist
                Node node = buckets[bi].remove(di);
                n--;
                return node.value ;
            }
        }
        //return all values of buckets
        public ArrayList<K> KeySet(){
            ArrayList<K> keys = new ArrayList<>();
            
            for(int i=0 ; i<buckets.length ; i++){
                LinkedList<Node> ll = buckets[i];

                for(int j=0 ; j<ll.size();i++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
        //get key
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key ,bi);//data index 

            if(di==-1){//key doesnt exist
                return null;
            }else{//key exist
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();
        map.put("India" , 125);
        map.put("china",200);
        map.put("US",100);
        map.put("mexico", 30);

           ArrayList<String> keys = new ArrayList<>();

        for(int i=0 ; i<keys.size() ; i++){
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
    }
}
