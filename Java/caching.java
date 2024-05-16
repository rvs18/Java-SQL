// Implement your own caching

// Implementing a simple in-memory cache in Java: 

// import java.util.HashMap;
// import java.util.Map;

public class SimpleCache<K, V> {
    private final Map<K, V> cacheMap;
    private final long expirationTime; // Time in milliseconds

    public SimpleCache(long expirationTime) {
        this.cacheMap = new HashMap<>();
        this.expirationTime = expirationTime;
    }

    public synchronized void put(K key, V value) {
        cacheMap.put(key, value);
    }

    public synchronized V get(K key) {
        if (!cacheMap.containsKey(key)) {
            return null; // Cache miss
        }
        
        V value = cacheMap.get(key);
        if (isExpired(key)) {
            cacheMap.remove(key);
            return null; // Cache expired
        }
        
        return value;
    }

    private boolean isExpired(K key) {
        // Check if the key has expired based on the expiration time
        // You can implement this based on creation time or last access time
        // For simplicity, we're using a fixed expiration time
        // You might want to implement a more sophisticated expiration mechanism
        return System.currentTimeMillis() - cacheMap.get(key) > expirationTime;
    }
}

// In this implementation:

// SimpleCache is a generic class that takes two parameters K for the key type and V for the value type.
// The cache is backed by a HashMap.
// The put method stores the key-value pair in the map.
// The get method retrieves the value associated with the key. If the key is not found or the cached value has expired, it returns null.
// The isExpired method checks if a cached value has expired based on a fixed expiration time.