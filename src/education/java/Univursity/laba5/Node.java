package education.java.Univursity.laba5;

class Node implements Comparable{
	int iData; // Вес символа (частота)
	char value; // Сам символ
	Boolean isTrail = false; // Является ли этот узел конечным (листом)
	Node leftChild; // Левый потомок узла
	Node rightChild; // Правый потомок узла

	public Node(int weight, char value) { // Конструктор узла
		iData = weight;
		this.value = value;
		isTrail = true;
	}

	@Override // Используется для сортировки приоритетной очереди
	public int compareTo(Object o) {
		if(!(o instanceof Node)) return 0;
		else {
			Node n = (Node)o;
			return iData - n.iData;
		}
	}
}