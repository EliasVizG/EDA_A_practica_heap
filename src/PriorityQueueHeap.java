
public class PriorityQueueHeap<E extends Comparable<E>> {
	private class Node implements Comparable<Node> {
		E data;
		int priority;

		private Node(E data, int priority) {
			this.data = data;
			this.priority = priority;
		}

		public E getData() {
			return this.data;
		}

		public int getPrio() {
			return this.priority;
		}

		public int compareTo(Node c) {
			if (this.getPrio() > c.getPrio())
				return 1;
			else if (this.getPrio() < c.getPrio())
				return -1;
			else
				return 0;
		}

		public String toString() {
			return "Node [data=" + data + ", priority=" + priority + "]";
		}
	}

	private HeapMax<Node> queue;
	private int size;
	private Node back;

	public PriorityQueueHeap() {
		queue = new HeapMax<Node>();
		this.back = new Node(null, Integer.MAX_VALUE);
	}

	public void enqueue(E newElement, int priority) {
		Node newNode = new Node(newElement, priority);
		if (newNode.compareTo(this.back) == -1)
			this.back = newNode;
		queue.insert(newNode);
	}

	public Node dequeue() {
		return queue.removeMax();
	}

	public Node front() {
		return queue.getMax();
	}

	public Node back() {
		return this.back;
	}

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
}
