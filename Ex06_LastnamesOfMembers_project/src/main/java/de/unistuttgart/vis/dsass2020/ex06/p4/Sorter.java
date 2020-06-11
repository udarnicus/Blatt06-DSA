package de.unistuttgart.vis.dsass2020.ex06.p4;

public class Sorter {


	/**
	 * Creates a Heap out of the list, then sorts it in incresing order with the heap sort algorithm
	 *
	 * precondition: list!=null
	 * postcondition: list is sorted in increasing order
	 *
	 * @param list
	 * @param <T>
	 */
	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {
		if(list == null){
			throw new IllegalArgumentException();
		}else{
			ISimpleList<T> unsortedList = createHeapProperties(list);
			heapSortAlgorithm(unsortedList);
		}


	}

	/**
	 * Creates a MaxHeap out of the given list
	 *
	 * Every child node should be smaller than its parent node
	 *
	 * @param list
	 * @return
	 */

	private static ISimpleList createHeapProperties(ISimpleList list){
		int index = (list.size() -1) / 2;
		while(index >= 0){
			percolate(list, index, list.size()-1);
			index--;
		}
		return list;
	}

	/**
	 * Percolate element for MaxHeap
	 *
	 * @param list
	 * @param idx
	 * @param last
	 */
	private static void percolate(ISimpleList list, int idx, int last) {
		int i = idx, j;
		while ((2*i)+1 <= last) {
			j = (2*i)+1;
			if (j+1 <= last) {
				if (list.get(j).compareTo(list.get(j+1)) < 0) {
					j++;
				}
			}
			if (list.get(i).compareTo(list.get(j)) < 0) {
				list.swap(i, j);
				i = j;
			} else {
				break;
			}
		}
	}

	/**
	 * Sorts the MaxHeap in list form in increasing order
	 *
	 * @param list
	 */
	public static void heapSortAlgorithm(ISimpleList list) {
		int i;
		for (i = list.size() / 2; i >= 0; i--) {
			percolate(list, i, list.size()-1);
		}
		for (i = list.size() - 1; i > 0; i--) {

			list.swap(0, i);
			percolate(list, 0, i-1);
		}

	}

}
