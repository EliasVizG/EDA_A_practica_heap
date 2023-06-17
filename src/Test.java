public class Test {
	public static void main(String[] args) {
		HeapMax<Integer> priorityQueue = new HeapMax<>();

		priorityQueue.insert(5);
		priorityQueue.insert(10);
		priorityQueue.insert(3);
		priorityQueue.insert(8);
		priorityQueue.insert(40);

		while (!priorityQueue.isEmpty()) {
			System.out.println("Dequeued: " + priorityQueue.removeMax());
		}
	}

}
