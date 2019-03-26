package Problems.Onsite.dataStructure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shuhanliu on 3/13/19.
 *
 * Create a map with expiring entries:
 * 思路：两个hash map，一个记录key，value pair，一个记录key的过期时间，
 * get的时候检查key是否过期，如果过期了，删除key返回null
 * Put方法有三个参数，除了key，value还有个duration
 *
 * Follow up: 采用更主动的策略删除过期的Key
 * 思路；创建后台线程定期清理过期的Key。
 * 用两个map，一个装<key, value>一个装<key, expiredTime>
 * 在get中采用lazy deletion，get的时候检查key是否过期，如果过期的话两个map中都删除key，返回null。
 * put的时候每次都更新key的expiredTime。
 * 后台线程每过一段时间遍历所有key，调用get方法删除过期key。此处为了避免多线程冲突，Map用ConcurrentHashMap实现。
 *
 */
public class HashMapWithExpire {

    public static void main(String[] args) throws InterruptedException {
        ExpireMap<Integer, Integer> expireMap = new ExpireMap<>();
        System.out.println(expireMap.get(0));
        expireMap.put(0, 1, 1000L);
        Thread.sleep(500L);
        System.out.println(expireMap.get(0));
        Thread.sleep(500L);
        System.out.println(expireMap.get(0));
        expireMap.release();
    }

    static class ExpireMap<K, V> {
        Map<K, V> valueMap;
        Map<K, Long> timeMap;

        private Thread cleanThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try{
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    for (K key : timeMap.keySet())
                        get(key);
                }
            }
        });

        public ExpireMap() {
            valueMap = new ConcurrentHashMap();
            timeMap = new ConcurrentHashMap();
            cleanThread.start();
        }

        public V get(K key) {

            if (!valueMap.containsKey(key))
                return null;

            Long curTime = System.currentTimeMillis();

            if (curTime > timeMap.get(key)) {
                valueMap.remove(key);
                timeMap.remove(key);
                return null;
            } else {
                return valueMap.get(key);
            }
        }

        public void put(K key, V value, Long expireIn) {
            Long curTime = System.currentTimeMillis();
            valueMap.put(key, value);
            timeMap.put(key, curTime + expireIn);
        }

        public void release() {
            try {
                cleanThread.join();
                cleanThread.stop();
                System.out.println("Thread is released");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
