package cache.cachemanager;

import cache.eviction.Eviction;
import cache.exceptions.KeyNotFoundException;
import cache.exceptions.NullElementException;
import cache.storage.Storage;

public class DefaultCacheManager<K, V> implements CacheManager<K, V> {
	private final Storage<K, V> storageService;
	private final Eviction<K> evictionService;
	
	public DefaultCacheManager(Storage<K, V> storageService, Eviction<K> evictionService) {
		this.storageService = storageService;
		this.evictionService = evictionService;
	}
	
	@Override
	public void addData(K key, V value) throws NullElementException {
		if (key == null || value == null) {
			throw new NullElementException("Key or Value cannot be null");
		}
		if (storageService.getSize() >= storageService.getCapacity()) {
			K evictedKey = evictionService.evict();
			if (evictedKey != null) {
				storageService.removeData(evictedKey);
			}
		}
		storageService.storeData(key, value);
		evictionService.accessed(key);
	}
	
	@Override
	public V getData(K key) throws KeyNotFoundException, NullElementException {
		if (key == null) {
			throw new NullElementException("Key cannot be null");
		}
		V value = storageService.getData(key);
		evictionService.accessed(key);
		return value;
	}
}