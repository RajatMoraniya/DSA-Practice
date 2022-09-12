package Hasshing;

import java.util.ArrayList;

//MapNode Class + Constructor
class MapNode<K , V>{
    K key;
    V value;
    MapNode<K ,V> next;

    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
        next = null;
    }
}


public class Map<K , V> {
    ArrayList<MapNode<K,V>> bucket; //Main Excel of Working [- - - - - -] ;
    int size; //actual filled size
    int numBuckets; //total size of arrayList includes null++;

    public Map(){
        // taking 20 size arrayList and putting null in all bucket;
        numBuckets = 5;
        bucket = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i++){
            bucket.add(null);
        }
    }

    //getBucketIndex
    private int getbucketIndex(K key){
        int hashCode = key.hashCode();
        return hashCode%numBuckets;
    }

    //size
    public int getSize(){
        return size;
    }

    //delete key and return value;
    public V deleteKey(K key){
        int bucketIndex = getbucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        MapNode<K,V> prev = null;
        while (head!= null){
            if(head.key.equals(key)){
                size--;
                if(prev==null){
                    bucket.set(bucketIndex,head.next);
                }
                else {
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    //getValue
    public V getValue(K key){
        int bucketIndex = getbucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        while (head!= null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    //loadfactor
    public double loadfactor(){
        return (1.0*size)/numBuckets;
    }
    //rehash
    private void rehash(){
        System.out.println("Rehashing : buckets - " + numBuckets + " size - " + size);
        ArrayList<MapNode<K,V>> temp = bucket;
        bucket = new ArrayList<>();
        for(int i =0 ; i < 2*numBuckets ; i++){
            bucket.add(null);
        }
        size = 0;
        numBuckets *=2;
        for(int i = 0 ; i < temp.size() ; i++){
            MapNode<K,V> head = temp.get(i);
            while(head!=null){
                K key = head.key;
                V value = head.value;
                insert(key,value);
                head = head.next;
            }
        }
    }

    //Insert Key Value pair
    public void insert(K key , V value){
        int bucketIndex = getbucketIndex(key);
        MapNode<K,V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucket.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<K,V>(key,value);
        size++;
        newNode.next = head;
        bucket.set(bucketIndex,newNode);
        double loadfactor = (1.0*size)/numBuckets;
        if(loadfactor>0.7){
            rehash();
        }
    }

    //main
    public static void main(String[] args) {
    Map<String,Integer> map = new Map<>();
    for(int i = 0 ; i < 20 ; i++){
        map.insert("abc" + i  , 1+ i) ;
        System.out.println("i =" + i + " if = " + map.loadfactor());
    }
    map.deleteKey("abc"+3);
    map.deleteKey("abc7");
    for(int i = 0 ; i < 20 ; i++){
        System.out.println("abc"+i+" "+ map.getValue("abc"+i));
    }
    }

}
