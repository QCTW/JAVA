/**
 * 
 * QuickSort Java implementation according to "Introduction to Algorithms" Chapter 7
 * 
 * @author Quincy
 *
 */
public class QuickSort
{
	private final int[] nArrayToSort;

	QuickSort(int[] nArray)
	{
		nArrayToSort = nArray;
	}

	public void sort()
	{
		System.out.println("Sort:" + Utility.printArray(nArrayToSort) + ", nPivotPos=0, nEndPos=" + (nArrayToSort.length - 1));
		sort(nArrayToSort, 0, nArrayToSort.length - 1);
	}

	public void sort(int[] nSubArray, int nPivotPos, int nEndPos)
	{
		if (nPivotPos < nEndPos)
		{
			int nMiddleIndex = partition(nSubArray, nPivotPos, nEndPos);
			System.out.println("Sort left part:" + Utility.printArray(nSubArray) + ", nPivotPos=" + nPivotPos + ", nMiddleIndex=" + nMiddleIndex);
			sort(nSubArray, nPivotPos, nMiddleIndex - 1);
			System.out.println("Sort right part:" + Utility.printArray(nSubArray) + ", nMiddleIndex=" + nMiddleIndex + ", nEndPos=" + nEndPos);
			sort(nSubArray, nMiddleIndex + 1, nEndPos);
		}
	}

	private int partition(int[] nSubArray, int nStartPos, int nPivotPos)
	{
		int nPivotValue = nSubArray[nPivotPos];
		// Initially, dock the [next pivot] to [starting position-1]
		int nNextPivot = nStartPos - 1;
		// Check each value in the array from the start position until [current pivot's position-1]
		for (int nPos2Check = nStartPos; nPos2Check <= nPivotPos - 1; nPos2Check++)
		{
			int nValue2Check = nSubArray[nPos2Check];
			if (nValue2Check <= nPivotValue)
			{
				// If current checking value is smaller than pivot's value,
				// [next pivot] move 1 right and swap its value with current value.
				// That is, move current value, which is smaller than pivot's value, to the left of the [next pivot].
				nNextPivot = nNextPivot + 1;
				swap(nSubArray, nNextPivot, nPos2Check);
			}
		}
		// Last, swap [current pivot's value] with [next pivot's value]
		nNextPivot = nNextPivot + 1;
		swap(nSubArray, nNextPivot, nPivotPos);
		System.out.println("Partitioning:" + Utility.printArray(nSubArray) + ", nPivotValue=" + nPivotValue + " (" + nPivotPos + "), nStartPos=" + nStartPos + ", nNextPivot=" + nNextPivot);
		return nNextPivot;
	}

	private void swap(int[] nSubArray, int nNextPivot, int nTarget)
	{
		if (nNextPivot != nTarget)
		{
			System.out.println("Swap value:" + nSubArray[nNextPivot] + " (Pos:" + nNextPivot + ")<->" + nSubArray[nTarget] + " (Pos:" + nTarget + ")");
			int nTmp = nSubArray[nTarget];
			nSubArray[nTarget] = nSubArray[nNextPivot];
			nSubArray[nNextPivot] = nTmp;
		}
	}

	public static void main(String[] strArg)
	{
		int[] nToTest = new int[] { 2, 8, 7, 1, 3, 5, 6, 4 };
		// Simulator.generateIntArray(10, 50, 0);
		QuickSort qs = new QuickSort(nToTest);
		qs.sort();
	}
}
