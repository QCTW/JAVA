import java.util.Random;

public class Simulator
{
	public static int[] generateIntArray(int nSize, int nMax, int nMin)
	{
		int[] naNew = new int[nSize];
		Random rand = new Random();
		for (int i = 0, iMax = nSize; i < iMax; i++)
		{
			int nNew = rand.nextInt((nMax - nMin) + 1) + nMin;
			naNew[i] = nNew;
		}
		return naNew;
	}
}
