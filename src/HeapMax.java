import java.util.ArrayList;

public class HeapMax<E extends Comparable<E>> {
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

	private void swap(int firstNode, int secondNode) {
        E temp = heapData.get(firstNode);
        heapData.set(firstNode, heapData.get(secondNode));
        heapData.set(secondNode, temp);
    }

	
	 private void maxHeapify(int position) {
        if (!checkLeaf(position)) {
            int leftChild = getLeftChildPosition(position);
            int rightChild = getRightChildPosition(position);

            int largest = position;

            if (leftChild < size && heapData.get(leftChild).compareTo(heapData.get(largest)) > 0)
                largest = leftChild;

            if (rightChild < size && heapData.get(rightChild).compareTo(heapData.get(largest)) > 0)
                largest = rightChild;

            if (largest != position) {
                swap(position, largest);
                maxHeapify(largest);
            }
        }
    }

	 public void insert(E data) {
        heapData.add(data);
        int current = size;
        size++;

        while (current > 0 && heapData.get(current).compareTo(heapData.get(getParentPosition(current))) > 0) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }
    }
	 public E removeMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        E max = heapData.get(0);
        heapData.set(0, heapData.get(size - 1));
        heapData.remove(size - 1);
        size--;

        maxHeapify(0);

        return max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

