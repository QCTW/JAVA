public class BinarySearch
{
	public static void main(String[] args)
	{
		int[] iaTestee = new int[] { 5, 6, 4, 3, 2, 7, 8, 1, 10, 0 };
		Node nRoot = BuildTree(iaTestee);
		Node nKeyNode = nRoot.FindKey(10);
		System.out.print("Result: " + nKeyNode.GetKeyValue());
	}

	private static Node BuildTree(int[] iaTestee)
	{
		Node nRoot = null;
		for (int iData : iaTestee)
		{
			if (nRoot == null)
			{
				nRoot = new Node(iData);
			} else
			{
				nRoot.AddNode(new Node(iData));
			}
		}
		return nRoot;
	}

}
