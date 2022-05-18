package education.java.Univursity.GraphProject;

class Vertex {
	public char label; // ћетка (например, СAТ)
	public boolean wasVisited;

	public Vertex(char lab) {
		label = lab;
		wasVisited = false;
	}
}
