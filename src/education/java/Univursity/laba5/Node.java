package education.java.Univursity.laba5;

class Node implements Comparable{
	int iData; // ��� ������� (�������)
	char value; // ��� ������
	Boolean isTrail = false; // �������� �� ���� ���� �������� (������)
	Node leftChild; // ����� ������� ����
	Node rightChild; // ������ ������� ����

	public Node(int weight, char value) { // ����������� ����
		iData = weight;
		this.value = value;
		isTrail = true;
	}

	@Override // ������������ ��� ���������� ������������ �������
	public int compareTo(Object o) {
		if(!(o instanceof Node)) return 0;
		else {
			Node n = (Node)o;
			return iData - n.iData;
		}
	}
}