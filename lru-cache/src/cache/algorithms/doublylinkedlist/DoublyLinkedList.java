package cache.algorithms.doublylinkedlist;

import cache.algorithms.linkedlistnode.Node;
import cache.exceptions.NullElementException;

public class DoublyLinkedList<K> {
	private final Node<K> head;
	private final Node<K> tail;
	
	public DoublyLinkedList() {
		head = new Node<>(null);
		tail = new Node<>(null);
		head.next = tail;
		tail.previous = head;
	}
	
	public Node<K> addElementAtLast(K element) throws NullElementException {
		if (element == null) {
			throw new NullElementException("Element cannot be null");
		}
		Node<K> node = new Node<>(element);
		Node<K> lastPrevious = tail.previous;
		lastPrevious.next = node;
		node.next = tail;
		tail.previous = node;
		node.previous = lastPrevious;
		return node;
	}
	
	public void detachNode(Node<K> node) {
		if (node == null || node.previous == null || node.next == null) return;
		node.previous.next = node.next;
		node.next.previous = node.previous;
	}
	
	public Node<K> getFirstNode() {
		return head.next == tail ? null : head.next;
	}
	
	public Node<K> getLastNode() {
		return tail.previous == head ? null : tail.previous;
	}
}