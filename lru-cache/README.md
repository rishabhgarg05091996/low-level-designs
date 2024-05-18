# Cache System with LRU Eviction Policy

This project implements a cache system with a Least Recently Used (LRU) eviction policy. It is designed to be extendable and scalable, adhering to best practices in Java programming. The system supports basic cache operations such as adding, retrieving, and removing data while managing its size using the LRU eviction mechanism.

## Project Structure
- **cache.cacheManager** : Manages cache operations.
- **cache.eviction** : Implements the LRU eviction strategy.
- **cache.exceptions** : Defines custom exceptions.
- **cache.storage** : Manages data storage in the cache.
- **cache.algorithms** : Contains data structures used by the eviction policy.

## Usage
### Initializing the Cache
- **Initialize the eviction service:** Eviction<String> evictionService = new DefaultLRUEvictionService<>();
- **Initialize the storage:** Storage<String, String> storageService = new DefaultStorageService<>(5, evictionService);
- **Initialize the cache manager:** CacheManager<String, String> cacheManager = new DefaultCacheManager<>(storageService, evictionService);

### Performing Operations
- **Adding data to the cache:** cacheManager.addData("key1", "value1");
- **Retrieving data from the cache:** String value = cacheManager.getData("key1");
- **Removing data from the cache:** cacheManager.removeData("key1");