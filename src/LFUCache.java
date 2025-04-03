import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache {
    public static void main2(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        System.out.println(lfuCache.get(2));
        lfuCache.put(2, 6);
        System.out.println(lfuCache.get(1));
        lfuCache.put(1, 5);
        lfuCache.put(1, 2);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
    }

    class Item implements Comparable<Item>{
        int key;
        int val;
        int freq;
        Long recentTimeCounter;

        @Override
        public int compareTo(Item a)
        {
            return this.recentTimeCounter.compareTo(a.recentTimeCounter);
        }
    }

    int capacity;
    HashMap<Integer,Item> map;
    PriorityQueue<Integer> freqsQueue;
    HashMap<Integer,PriorityQueue<Item>> freqItemMap;
    public LFUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        freqsQueue=new PriorityQueue<>();
        freqItemMap=new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        increateFreq(key);
        return map.get(key).val;
    }
    private void increateFreq(int key){
        Item item=map.get(key);
        if(freqItemMap.containsKey(item.freq)){
            if(freqItemMap.get(item.freq).size()==1)
                freqsQueue.remove(item.freq);
            freqItemMap.get(item.freq).remove(item);
        }
        item.freq++;
        item.recentTimeCounter=System.currentTimeMillis();
        PriorityQueue<Item> newQueue=freqItemMap.get(item.freq);
        if(newQueue==null){
            newQueue=new PriorityQueue<Item>();
            freqItemMap.put(item.freq,newQueue);
        }
        newQueue.add(item);
        if(newQueue.size()==1){
            freqsQueue.add(item.freq);
        }
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)&&map.size()==capacity){
            removeLFU();
        }
        Item item=map.get(key);
        if(item==null){
            item=new Item();
            item.freq=0;
            item.key=key;
            map.put(key,item);
        }
        item.val=value;
        increateFreq(key);
    }
    private void removeLFU(){
        int removeFreq=freqsQueue.peek();
        Item removeItem=freqItemMap.get(removeFreq).poll();
        map.remove(removeItem.key);
        if(freqItemMap.get(removeFreq).size()==0){
            freqsQueue.poll();
        }
    }

}