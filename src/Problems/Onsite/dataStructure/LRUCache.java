package Problems.Onsite.dataStructure;

import java.util.*;

/**
 * Created by shuhanliu on 2/28/19.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists
 in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache( 2 );  -- 2 is capacity

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 *
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node dummy;
    private Node tail;
    private Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummy = new Node(0, 0);
        tail = new Node(0, 0);
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        int rtnVal = node.val;
        removeFromList(node);
        addToFront(node);
        return rtnVal;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node toRemove = map.get(key);
            removeFromList(toRemove);
            removeFromMap(toRemove);
        } else if (map.size() == capacity) {
            Node toRemove = tail.prev;
            removeFromList(toRemove);
            removeFromMap(toRemove);
        }

        Node toAdd = new Node(key, value);
        addToFront(toAdd);
        addToMap(toAdd);
    }

    private void addToFront(Node node) {
        Node next = dummy.next;
        node.prev = dummy;
        dummy.next = node;
        node.next = next;
        next.prev = node;
    }

    private void removeFromList(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToMap(Node node) {
        map.put(node.key, node);
    }

    private void removeFromMap(Node node) {
        map.remove(node.key);
    }
}
