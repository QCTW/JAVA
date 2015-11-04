
public class Utility
{
	public static String printArray(int[] nSubArray)
	{
		StringBuffer sb = new StringBuffer("[ ");
		for (int nEle : nSubArray)
		{
			sb.append(nEle + " ");
		}
		sb.append("]");
		return sb.toString();
	}
}
