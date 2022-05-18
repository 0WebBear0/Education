package education.java.Univursity.GraphProject;

public class StackForGraph {
	private final int SIZE = 20;
	private int[] st;
	private int top;

	// -----------------------------------------------------------
	public StackForGraph() // Конструктор
	 {
	 st = new int[SIZE]; // Создание массива
	 top = -1;
	 }

	public void push(int j) // Размещение элемента в стеке
	{
		st[++top] = j;
	}

	// -----------------------------------------------------------
	public int pop() // Извлечение элемента из стека
	{
		return st[top--];
	}

	// ------------------------------------------------------------
	public int peek() // Чтение с вершины стека
	{
		return st[top];
	}

	// ------------------------------------------------------------
	public boolean isEmpty() // true, если стек пуст
	{
		return (top == -1);
	}
	// ------------------------------------------------------------
}
