package education.java.Univursity.GraphProject;

public class StackForGraph {
	private final int SIZE = 20;
	private int[] st;
	private int top;

	// -----------------------------------------------------------
	public StackForGraph() // �����������
	 {
	 st = new int[SIZE]; // �������� �������
	 top = -1;
	 }

	public void push(int j) // ���������� �������� � �����
	{
		st[++top] = j;
	}

	// -----------------------------------------------------------
	public int pop() // ���������� �������� �� �����
	{
		return st[top--];
	}

	// ------------------------------------------------------------
	public int peek() // ������ � ������� �����
	{
		return st[top];
	}

	// ------------------------------------------------------------
	public boolean isEmpty() // true, ���� ���� ����
	{
		return (top == -1);
	}
	// ------------------------------------------------------------
}
