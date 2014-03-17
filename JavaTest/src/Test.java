
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String strTestString = "TEST";
		Test t = new Test();
		//Here we pass a "copy reference" of strTestString into ModifyString!!
		t.ModifyString(strTestString);
		System.out.println(strTestString);
	}

	public boolean ModifyString(String strToBeModify)
	{
		strToBeModify = "Modified test";
		return true;
	}
}
