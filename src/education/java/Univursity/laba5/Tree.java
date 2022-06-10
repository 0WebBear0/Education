package education.java.Univursity.laba5;

import java.util.*;

class Tree { //��������� ������ �� ������� "�������� �������", ���������� ��� ����� �������
	Node root; // ������������ ���� ������

	public Node find(char key) // ����� ���� � �������� ������
	{ // (��������������, ��� ������ �� ������)
		Node current = root; // ������ � ��������� ����
		while (current.value != key) // ���� �� ������� ����������
		{
			if (key < current.iData) // ��������� ������?
				current = current.leftChild;
			else
				current = current.rightChild; // ��� �������?
			if (current == null) // ���� ������� ���,
				return null; // ����� ���������� ��������
		}
		return current; // ������� ������
	}

	public void insert(int id, char dd) {
		Node newNode = new Node(id, dd); // �������� ������ ����
		if (root == null) {
			root = newNode;
		} // �������� ���� �� ����������
		else // �������� ���� �����
		{
			Node current = root; // ������ � ��������� ����
			Node parent;
			while (true) // (���������� ����� �� �����)
			{
				parent = current;
				if (id < current.iData) // ��������� ������?
				{
					current = current.leftChild;
					if (current == null) // ���� ��������� ����� �������
					{ // �������� �����
						parent.leftChild = newNode;
						return;
					}
				} else // ��� �������?
				{
					current = current.rightChild;
					if (current == null) // ���� ��������� ����� �������,
					{ // �������� ������
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public String Decode(String input) {
		String result = "";
		Node current = root;
		for(int i = 0; i < input.length(); i++) {
			char next = input.charAt(i);
			if(next == '0')
				current = current.leftChild;
			else
				current = current.rightChild;
			if(current.isTrail) {
				result += current.value;
				current = root;
			}
		}
		return result;
	}

	private void inOrder(Node localRoot, int currentDepth, String currentCode, HashMap<Character, String> codeTable) {
		if (localRoot != null) {
			String left = currentCode + "0"; // 0 � ����� �����
			if(localRoot.leftChild != null && !localRoot.leftChild.isTrail) localRoot.leftChild.value = '0';
 			inOrder(localRoot.leftChild, currentDepth + 1, left, codeTable);
			if(localRoot.isTrail) { //������� ��� � ������ ������ � ������ 
				System.out.println("  ".repeat(currentDepth) + "[" + (localRoot.value == '\n' ? "<Line Break>" : localRoot.value) + "]" + "(" + currentCode + ")");
				codeTable.put(localRoot.value, currentCode);
			}
			else
				System.out.println("  ".repeat(currentDepth) + localRoot.value);
			String right = currentCode + "1"; // 1 � ������ �����
			if(localRoot.rightChild != null && !localRoot.rightChild.isTrail) localRoot.rightChild.value = '1';
			inOrder(localRoot.rightChild, currentDepth + 1, right, codeTable);
		}
	}

	public void printTree(HashMap<Character, String> codeTable) { // ����� ������ ��������
		root.value = 'x';
		inOrder(root, 0, "", codeTable);
	}

	public Node minimum() // ���������� ���� � ����������� ������
	{
		Node current, last = null;
		current = root; // ����� ���������� � ��������� ����
		while (current != null) // � ������������ �� ����
		{
			last = current; // ���������� ����
			current = current.leftChild; // ������� � ������ �������
		}
		return last;
	}

	public boolean delete(int key) // �������� ���� � �������� ������
	{ // (��������������, ��� ������ �� �����)
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		while (current.iData != key) // ����� ����
		{
			parent = current;
			if (key < current.iData) // ��������� ������?
			{
				isLeftChild = true;
				current = current.leftChild;
			} else // ��� �������?
			{
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) // ����� �������
				return false; // ���� �� ������
		}
		// ��������� ���� ������
		// ���� ���� �� ����� ��������, �� ������ ���������.
		// ��� ������ ������
		if (current.leftChild == null && current.rightChild == null) {
			if (current == root) // ���� ���� �������� ��������,
				root = null; // ������ ���������
			else if (isLeftChild)
				parent.leftChild = null; // ���� �������������
			else // �� ��������
				parent.rightChild = null;
		}
		// ����������� delete()...

		// ������ 2
		// ����������� delete()...
		// ���� ��� ������� �������, ���� ���������� ����� ����������
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild) // ����� ������� ��������
				parent.leftChild = current.leftChild;
			else // ������ ������� ��������
				parent.rightChild = current.leftChild;
		// ���� ��� ������ �������, ���� ���������� ������ ����������
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild) // ����� ������� ��������
				parent.leftChild = current.rightChild;
			else // ������ ������� ��������
				parent.rightChild = current.rightChild;
		// ������ 3
		// --------------------
		else // ��� �������, ���� ���������� ����������
		{
			// ����� ��������� ��� ���������� ���� (current)
			Node successor = getSuccessor(current);
			// �������� current ����������� � �����������
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			// �������� ����������� � ����� �������� current
			successor.leftChild = current.leftChild;
		} // ����� else ��� ���� ��������
			// (�������� �� ����� ����� ������ �������)
		return true;

	}

	// ����� ���������� ���� �� ��������� ��������� ����� delNode.
	// ��� ����� �� ������� ��������� � ������� �������, � �����
	// ����������� ������� ����� �������� ����� ����.
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; // ������� � ������� �������
		while (current != null) // ���� �������� ����� �������
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild; // ������� � ������ �������
		}
		// ���� �������� �� ��������
		if (successor != delNode.rightChild) // ������ ��������,
		{ // ������� ����� ����� ������
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
}
