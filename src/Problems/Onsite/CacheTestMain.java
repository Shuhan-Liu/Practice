package Problems.Onsite;

import Tool.Printer;

/**
 * Created by shuhanliu on 2/28/19.
 */
public class CacheTestMain {

    public static void main(String[] args) {
        runLRUTest2();
    }
    // ["LRUCache","get","put","get","put","put","get","get"]
    // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    // [null,-1,null,-1,null,null,2,6]
    public static void runLRUTest2() {
        LRUCache cache = new LRUCache( 2 );

        Printer.printResult(cache.get(2));       // returns -1 (not found)
        cache.put(2, 6);
        Printer.printResult(cache.get(1));       // returns -1 (not found)
        cache.put(1, 5);
        cache.put(1, 2);    // evicts key 1
        Printer.printResult(cache.get(1));       // returns 2 (not found)
        Printer.printResult(cache.get(2));       // returns 6
    }

    public static void runLRUTest1() {

        LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        Printer.printResult(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Printer.printResult(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        Printer.printResult(cache.get(1));       // returns -1 (not found)
        Printer.printResult(cache.get(3));       // returns 3
        Printer.printResult(cache.get(4));       // returns 4

    }

}
