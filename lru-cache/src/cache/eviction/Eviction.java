package cache.eviction;

import cache.exceptions.NullElementException;

public interface Eviction<K> {
	void accessed(K key) throws NullElementException;
	K evict();
}