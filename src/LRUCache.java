import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, CacheNode> dict;
    CacheNode head, tail;
    int capacity;
    int count;
    public LRUCache(int capacity) {
        dict = new HashMap<>();
        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!dict.containsKey(key)){
            return -1;
        }
        //has key
        CacheNode node = dict.get(key);
        //refresh the node
        refresh(node);

        return node.val;
    }

    public void put(int key, int value) {
        if(dict.containsKey(key)){
            //update the value and refresh the node
            CacheNode node = dict.get(key);
            node.val = value;
            refresh(node);
        }else{
            //add new node and evict the least recently used key if the count of nodes exceeds capacity
            CacheNode node = new CacheNode(key, value);
            dict.put(key, node);
            insertHead(node);
            count++;
            if(count > capacity){
                evict();
            }
        }
    }

    private void evict(){
        //remove the last node
        CacheNode removed = tail.prev;
        removed.prev.next = tail;
        tail.prev = removed.prev;
        dict.remove(removed.key);
    }

    private void refresh(CacheNode node){
        //change nodes before and after the node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        insertHead(node);
    }

    private void insertHead(CacheNode node){
        //change the node after the head
        node.next = head.next;
        head.next.prev = node;
        //change head
        node.prev = head;
        head.next = node;
    }
}

class CacheNode{
    int key, val;
    CacheNode next, prev;
    CacheNode(int key, int value){
        this.key = key;
        this.val = value;
    }
}
