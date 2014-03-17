public class Node
{
	Node m_nParent = null;
	Node m_nLeftChild = null;
	Node m_nRightChild = null;
	int m_iKey = -1;

	public Node(int iData)
	{
		m_iKey = iData;
	}

	void SetParent(Node nParentNode)
	{
		m_nParent = nParentNode;
	}

	void SetLeftChild(Node nSmallNode)
	{
		if (m_nLeftChild == null)
		{
			m_nLeftChild = nSmallNode;
			nSmallNode.SetParent(this);
		} else
		{
			m_nLeftChild.AddNode(nSmallNode);
		}
	}

	void SetRightChild(Node nBigNode)
	{
		if (m_nRightChild == null)
		{
			m_nRightChild = nBigNode;
			nBigNode.SetParent(this);
		} else
		{
			m_nRightChild.AddNode(nBigNode);
		}
	}

	Node GetParent()
	{
		return m_nParent;
	}

	public Node GetBiggerNode()
	{
		return m_nRightChild;
	}

	public Node GetSmallerNode()
	{
		return m_nLeftChild;
	}

	public int GetKeyValue()
	{
		return m_iKey;
	}

	public void AddNode(Node nNode2Add)
	{
		int iKeyValue2Add = nNode2Add.GetKeyValue();
		if (iKeyValue2Add >= m_iKey)
		{
			SetRightChild(nNode2Add);
		} else
		{
			SetLeftChild(nNode2Add);
		}
	}

	public Node FindKey(int iValue2Find)
	{
		Node nReturn = null;
		if (iValue2Find == m_iKey)
			nReturn = this;
		else
		{
			Node nNode2Insert = CompareWithSlibling(iValue2Find);
			System.out.println("Passby: " + nNode2Insert.GetKeyValue());
			nReturn = nNode2Insert.FindKey(iValue2Find);
		}
		return nReturn;
	}

	@Override
	public String toString()
	{
		return String.valueOf(m_iKey);
	}

	Node CompareWithSlibling(int iValue2Compare)
	{
		if (m_nRightChild != null)
		{
			if (iValue2Compare >= m_iKey)
				return m_nRightChild;
		}

		if (m_nLeftChild != null)
		{
			if (iValue2Compare < m_iKey)
				return m_nLeftChild;
		}

		return null;
	}
}
