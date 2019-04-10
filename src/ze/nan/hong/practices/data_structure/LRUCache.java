package ze.nan.hong.practices.data_structure;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    protected boolean removeEldestEntry(Map .Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        System.out.println(cache.keySet());
        cache.get(1);
        cache.put(4, "4");
        System.out.println(cache.keySet());
    }
}

final class ConcurrentCache<K, V> {
    private final int  size;
    private final Map<K, V> eden;
    private final Map<K, V> longtern;

    public ConcurrentCache(int size) {
        this.size = size;
        this.eden = new ConcurrentHashMap<>();
        this.longtern = new WeakHashMap<>();
    }

    public V get(K k) {
        V v = this.eden.get(k);
        if (v == null) {
            v = this.longtern.get(k);
            if (v != null) {
                this.eden.put(k, v);
            }
        }

        return v;
    }

    public void put(K k, V v) {
        if (this.eden.size() > size) {
            this.longtern.putAll(this.eden);
            this.eden.clear();
        }
        this.eden.put(k, v);
    }
}

