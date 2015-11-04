
public class MergeSort
{
	private final int[] nArray2Sort;

	public MergeSort(int[] nArr)
	{
		nArray2Sort = nArr;
	}

	public void sort()
	{
		System.out.println("Sorting:" + Utility.printArray(nArray2Sort));
		sort(nArray2Sort, 0, nArray2Sort.length - 1);
	}

	private void sort(int[] naTarget, int nStartPos, int nEndPos)
	{
		if (nStartPos < nEndPos)
		{
			int nMiddlePos = (int) Math.floor((nEndPos + nStartPos) / 2);
			System.out.println("Split " + Utility.printArray(naTarget) + " from position:" + nMiddlePos + ", nStartPos=" + nStartPos + ", nEndPos=" + nEndPos);
			sort(naTarget, nStartPos, nMiddlePos);
			sort(naTarget, nMiddlePos + 1, nEndPos);
			merge(naTarget, nStartPos, nMiddlePos, nEndPos);
		}
	}

	private void merge(int[] nArrSource, int nStartPos, int nMidPos, int nEndPos)
	{
		int[] nArrLeft = createSubArray(nArrSource, nStartPos, (nMidPos - nStartPos + 1));
		int[] nArrRight = createSubArray(nArrSource, nMidPos + 1, (nEndPos - nMidPos));
		int nLeftIndex = 0;
		int nRightIndex = 0;
		for (int k = nStartPos; k <= nEndPos; k++)
		{
			if (nArrLeft[nLeftIndex] <= nArrRight[nRightIndex])
			{
				nArrSource[k] = nArrLeft[nLeftIndex];
				nLeftIndex = nLeftIndex + 1;
			} else
			{
				nArrSource[k] = nArrRight[nRightIndex];
				nRightIndex = nRightIndex + 1;
			}
		}
		System.out.println("Merge " + Utility.printArray(nArrLeft) + "<-" + Utility.printArray(nArrRight) + ":" + Utility.printArray(nArrSource));
	}

	private int[] createSubArray(int[] nArrSource, int nStartPos, int nSize)
	{
		int[] nArrCopy = new int[nSize + 1];
		for (int i = 0; i < nSize; i++)
		{
			nArrCopy[i] = nArrSource[nStartPos + i];
		}
		nArrCopy[nSize] = Integer.MAX_VALUE;
		return nArrCopy;
	}

	public static void main(String[] args)
	{
		int[] nArray = new int[] { 2, 4, 5, 1, 7, 2, 3, 6 };
		MergeSort ms = new MergeSort(nArray);
		ms.sort();
	}

}
