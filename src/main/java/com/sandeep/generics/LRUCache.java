package com.sandeep.generics;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private int maxSize;
    LinkedHashMap<K,V> linkedHashMap;

    public LRUCache(int size){
        this.maxSize = size;
        this.linkedHashMap = new LinkedHashMap<K,V>(maxSize,0.75F, false){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        };
    }


    public void put(K k,V v){
        linkedHashMap.put(k,v);
    }
    public V get(K k){
        return linkedHashMap.getOrDefault(k,null);
    }

    public LinkedHashMap<K, V> getLinkedHashMap() {
        return linkedHashMap;
    }

    public static void main(String[] args) {
        LRUCache<String, String> lruCache = new LRUCache<>(4);
        lruCache.put("Sandeep", "Arcesium");
        lruCache.put("Ganesh", "Arcesium");
        lruCache.put("Dilip", "CreditSuisse");
        lruCache.put("Omer", "BNY");
        lruCache.get("Sandeep");
        lruCache.put("Sachin", "DBS");
        lruCache.put("Ashwin", "SAP");
        System.out.println("Cache "+ lruCache.getLinkedHashMap().keySet().toArray());
    }
}
