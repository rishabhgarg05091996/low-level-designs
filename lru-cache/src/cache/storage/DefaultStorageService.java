package cache.storage;

import cache.exceptions.KeyNotFoundException;
import cache.exceptions.NullElementException;

import java.util.HashMap;
import java.util.Map;

public class DefaultStorageService<K, V> implements Storage<K, V> {
	private static final int DEFAULT_CAPACITY = 5;
	private final int capacity;
	private final Map<K, V> storageMap;
	
	public DefaultStorageService(int capacity) {
		this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
		this.storageMap = new HashMap<>(capacity);
	}
	
	@Override
	public void storeData(K key, V value) throws NullElementException {
		if (key == null || value == null) {
			throw new NullElementException("Key or Value cannot be null");
		}
		storageMap.put(key, value);
	}
	
	@Override
	public V getData(K key) throws KeyNotFoundException {
		V value = storageMap.get(key);
		if (value == null) {
			throw new KeyNotFoundException("Key not found: " + key);
		}
		return value;
	}
	
	@Override
	public void removeData(K key) {
		storageMap.remove(key);
	}
	
	@Override
	public int getSize() {
		return storageMap.size();
	}
	
	@Override
	public int getCapacity() {
		return capacity;
	}
}