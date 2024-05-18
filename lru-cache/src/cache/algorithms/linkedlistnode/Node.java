package cache.algorithms.linkedlistnode;

public class Node<K> {
	private final K element;
	public Node<K> previous;
	public Node<K> next;
	
	public Node(K element) {
		this.element = element;
		this.previous = null;
		this.next = null;
	}
	
	public K getElement() {
		return element;
	}
	
	public Node<K> getPrevious() {
		return previous;
	}
	
	public Node<K> getNext() {
		return next;
	}
}