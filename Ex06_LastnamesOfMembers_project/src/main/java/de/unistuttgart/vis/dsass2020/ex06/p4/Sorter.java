package de.unistuttgart.vis.dsass2020.ex06.p4;

public class Sorter {

	public static <T extends Comparable<T>> void heapSort(ISimpleList<T> list) {
		ISimpleList unsortedList = createHeapProperties(list);
		heapSortAlgorithm(unsortedList);

	}

	/**
	 * creates HeapProperties for MaxHeap
	 *
	 * @param list
	 * @return
	 */

	public static ISimpleList createHeapProperties(ISimpleList list){
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
		while ((2*i)+1 <= last) { // f[i] hat linkes Kind
			j = (2*i)+1; // f[j] ist linkes Kind von f[i]
			if (j+1 <= last) { // f[i] hat auch rechtes Kind
				if (list.get(j).compareTo(list.get(j+1)) < 0) { // vergleiche Kinder
					j++; // f[j] ist jetzt kleiner
				}
			}
			if (list.get(i).compareTo(list.get(j)) < 0) { // vergleiche Elter mit Kind
				list.swap(i, j);
				i = j; // versickere weiter
			} else { // halte an, da Heap-Bedingung erfüllt
				break;
			}
		}
	}

	public static void heapSortAlgorithm(ISimpleList list) {
		int i;
		for (i = list.size() / 2; i >= 0; i--) {
			percolate(list, i, list.size()-1);
		}
		for (i = list.size() - 1; i > 0; i--) {
// tausche jeweils letztes Element des Heaps mit dem ersten
			list.swap(0, i);
// Heap wird von Position 0 bis i-1 hergestellt
			percolate(list, 0, i-1);
		}

	}

}
