import java.util.ArrayList;

public class HeapMax<E> {
	private ArrayList<E> heapData;
	private int size;

	public HeapMax() {
		this.size = 0;
		heapData = new ArrayList<E>();
	}

	private int getParentPosition(int position) {
		return (position - 1) / 2;
	}

	private int getLeftChildPosition(int position) {
		return (2 * position);
	}

	private int getRightChildPosition(int position) {
		return (2 * position) + 1;
	}

	private boolean checkLeaf(int position) {
		if (position > (size / 2) && position <= size)
			return true;
		else
			return false;
	}

	private void swap(intfirstNode, intsecondNode)  {   
        int temp;   
        temp = heapData[firstNode];   
        heapData[firstNode] = heapData[secondNode];   
        heapData[secondNode] = temp;   
    }

	// create maxHeapify() method to heapify the node for maintaining the heap
	// property
	private void maxHeapify(int position) {

		// check whether the given node is non-leaf and greater than its right and left
		// child
		if (!checkLeaf(position)) {
			if (heapData[position] < heapData[getLeftChildPosition(position)]
					|| heapData[position] < heapData[getRightChildPosition(position)]) {

				// swap with left child and then heapify the left child
				if (heapData[getLeftChildPosition(position)] > heapData[getRightChildPosition(position)]) {
					swap(position, getLeftChildPosition(position));
					maxHeapify(getLeftChildPosition(position));
				}

				// Swap with the right child and heapify the right child
				else {
					swap(position, getRightChildPosition(position));
					maxHeapify(getRightChildPosition(position));
				}
			}
		}
	}

	// create insertNode() method to insert element in the heap
	public void insert(E data) {
		heapData.add(data);
		int current = size;

		while (heapData[current] > heapData[getParentPosition(current)]) {
			swap(current, getParentPosition(current));
			current = getParentPosition(current);
		}
		sizeOfHeap++;
	}

}
