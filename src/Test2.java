public class Test2 {
	public static void main(String[] args) {
		PriorityQueueHeap<String> priorityQueue = new PriorityQueueHeap<>();

		priorityQueue.enqueue("oli", 5);
		priorityQueue.enqueue("zzz", 10);
		priorityQueue.enqueue("agag", 3);
		priorityQueue.enqueue("agasfghashshg", 3);
		priorityQueue.enqueue("ewe", 8);
		priorityQueue.enqueue("jlakdhnglkang", 8);

		System.out.println("back: " + priorityQueue.back());
		System.out.println("front: " + priorityQueue.front());
		System.out.println(priorityQueue.size());

		while (!priorityQueue.isEmpty()) {
			System.out.println("Dequeued: " + priorityQueue.dequeue());
			System.out.println(priorityQueue.size());
		}

	}

}
