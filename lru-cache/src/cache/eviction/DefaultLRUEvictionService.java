package cache.eviction;

import cache.algorithms.doublylinkedlist.DoublyLinkedList;
import cache.algorithms.linkedlistnode.Node;
import cache.exceptions.NullElementException;

import java.util.HashMap;
import java.util.Map;

public class DefaultLRUEvictionService<K> implements Eviction<K> {
	private final DoublyLinkedList<K> doublyLinkedList;
	private final Map<K, Node<K>> dllMapper;
	
	public DefaultLRUEvictionService() {
		this.doublyLinkedList = new DoublyLinkedList<>();
		this.dllMapper = new HashMap<>();
	}
	
	@Override
	public void accessed(K key) throws NullElementException {
		if (key == null) {
			throw new NullElementException("Key cannot be null");
		}
		Node<K> node = dllMapper.get(key);
		if (node != null) {
			doublyLinkedList.detachNode(node);
		}
		Node<K> newNode = doublyLinkedList.addElementAtLast(key);
		dllMapper.put(key, newNode);
	}
	
	@Override
	public K evict() {
		Node<K> node = doublyLinkedList.getFirstNode();
		if (node != null) {
			doublyLinkedList.detachNode(node);
			dllMapper.remove(node.getElement());
			return node.getElement();
		}
		return null;
	}
}