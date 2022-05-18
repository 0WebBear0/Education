package education.java.Univursity.GraphProject;

public class TCApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();

        theGraph.addVertex('A'); // 0
        theGraph.addVertex('B'); // 1
        theGraph.addVertex('C'); // 2
        theGraph.addVertex('D'); // 3
        theGraph.addVertex('E'); // 4
        theGraph.addEdgeSingle(0, 2); // AC
        theGraph.addEdgeSingle(1, 0); // BA
        theGraph.addEdgeSingle(1, 4); // BE
        theGraph.addEdgeSingle(3, 4); // DE
        theGraph.addEdgeSingle(4, 2); // EC

        theGraph.graphTransitiveClosure();
    }
}
