package cache.cachemanager;

import cache.exceptions.KeyNotFoundException;
import cache.exceptions.NullElementException;

public interface CacheManager<K, V> {
	void addData(K key, V value) throws NullElementException;
	V getData(K key) throws KeyNotFoundException, NullElementException;
}