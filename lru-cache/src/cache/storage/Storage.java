package cache.storage;

import cache.exceptions.KeyNotFoundException;
import cache.exceptions.NullElementException;

public interface Storage<K, V> {
	void storeData(K key, V value) throws NullElementException;
	V getData(K key) throws KeyNotFoundException, NullElementException;
	void removeData(K key);
	int getSize();
	int getCapacity();
}
