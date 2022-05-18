package education.java.Univursity.GraphProject;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // ������ ������
	private int adjMat[][]; // ������� ���������
	private int nVerts; // ������� ���������� ������

	private StackForGraph theStack;
	private QueueForGraph theQueue;
	// -------------------------------------------------------------

	public Graph() // �����������
	{
		vertexList = new Vertex[MAX_VERTS];
		// ������� ���������
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++) // ������� ���������
			for (int k = 0; k < MAX_VERTS; k++) // ����������� ������
				adjMat[j][k] = 0;
		theStack = new StackForGraph();
		theQueue = new QueueForGraph();
	}

	// -------------------------------------------------------------
	public void addVertex(char lab) // � ��������� ���������� �����
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	// -------------------------------------------------------------
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	// -------------------------------------------------------------
	public void addEdgeSingle(int start, int end) {
		adjMat[start][end] = 1;
	}

	// -------------------------------------------------------------
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void dfs() // ����� � �������
	{ // �������� �������� � ������� 0
		vertexList[0].wasVisited = true; // �������
		displayVertex(0); // �����
		theStack.push(0); // ��������� � ����
		while (!theStack.isEmpty()) // ���� ���� �� ��������
		{
			// ��������� ������������ �������, ������� � �������
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // ���� ����� ������� ���,
				theStack.pop(); // ������� ����������� �� �����
			else // ���� ������� �������
			{
				vertexList[v].wasVisited = true; // �������
				displayVertex(v); // �����
				theStack.push(v); // ��������� � ����
			}
		}
		// ���� ����, ������ ���������
		for (int j = 0; j < nVerts; j++) // ����� ������
			vertexList[j].wasVisited = false;
	}

	// ------------------------------------------------------------
	// ����� ���������� ������������ �������, ������� �� ��������� � v
	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j; // ���������� ������ ��������� �������
		return -1; // ����� ������ ���
	}

	public void bfs() // ����� � ������
	{ // �������� �������� � ������� 0
		vertexList[0].wasVisited = true; // �������
		displayVertex(0); // �����
		theQueue.insert(0); // ������� � ����� �������
		int v2;
		while (!theQueue.isEmpty()) // ���� ������� �� ��������
		{
			int v1 = theQueue.remove(); // ���������� ������� � ������ �������
			// ���� �������� ������������ ������
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // ��������� �������
				vertexList[v2].wasVisited = true; // �������
				displayVertex(v2); // �����
				theQueue.insert(v2); // �������
			}
		}
		// ������� �����, ����� ��������
		for (int j = 0; j < nVerts; j++) // ����� ������
			vertexList[j].wasVisited = false;
	}

	public void mst() // ���������� ������������ ��������� ������
	{ //
		vertexList[0].wasVisited = true; // �������
		theStack.push(0); // ��������� � ����
		while (!theStack.isEmpty()) // ���� ���� �� ��������
		{ // ���������� �������� �� �����
			int currentVertex = theStack.peek();
			// ��������� ���������� ������
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1) // ���� ������� ������ ���,
				theStack.pop(); // ������� ������� �� �����
			else // ����� ����������
			{
				vertexList[v].wasVisited = true; // �������
				theStack.push(v); // ��������� � ����
				// ����� �����
				displayVertex(currentVertex); // �� currentVertex
				displayVertex(v); // � v
				System.out.print(" ");
			}
		}
		// ���� ����, ������ ���������
		for (int j = 0; j < nVerts; j++) // ����� ������
			vertexList[j].wasVisited = false;
	}

	public void graphTransitiveClosure(){
		System.out.println("be was");

		printAdjMat();

		System.out.println("in calculated");
		for (int i = 0; i < nVerts; i++) {
			for (int j = 0; j < nVerts; j++) {
				if (adjMat[i][j] == 1){
					for (int k = 0; k < nVerts; k++) {
						if (adjMat[j][k] == 1){
							adjMat[i][k] = 1;
						}
					}
				}
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println("\nbecame");

		printAdjMat();
	}

	public void printAdjMat(){
		for (int i = 0; i < nVerts; i++) {
			for (int j = 0; j < nVerts; j++) {
				System.out.print(adjMat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
