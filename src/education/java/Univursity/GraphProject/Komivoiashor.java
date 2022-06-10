package education.java.Univursity.GraphProject;

public class Komivoiashor {

    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('1'); // 0 (исходная вершина)
        theGraph.addVertex('2'); // 1
        theGraph.addVertex('3'); // 2
        theGraph.addVertex('4'); // 3
        theGraph.addVertex('5'); // 4

        theGraph.addEdgeSingleWithData(0, 1, 100);
        theGraph.addEdgeSingleWithData(0, 2, 50);
        theGraph.addEdgeSingleWithData(0, 3, 0);
        theGraph.addEdgeSingleWithData(0, 4, 200);

        theGraph.addEdgeSingleWithData(1, 0, 0);
        theGraph.addEdgeSingleWithData(1, 2, 200);
        theGraph.addEdgeSingleWithData(1, 3, 50);
        theGraph.addEdgeSingleWithData(1, 4, 300);

        theGraph.addEdgeSingleWithData(2, 0, 50);
        theGraph.addEdgeSingleWithData(2, 1, 300);
        theGraph.addEdgeSingleWithData(2, 3, 50);
        theGraph.addEdgeSingleWithData(2, 4, 0);

        theGraph.addEdgeSingleWithData(3, 0, 0);
        theGraph.addEdgeSingleWithData(3, 1, 150);
        theGraph.addEdgeSingleWithData(3, 2, 50);
        theGraph.addEdgeSingleWithData(3, 4, 50);

        theGraph.addEdgeSingleWithData(4, 0, 200);
        theGraph.addEdgeSingleWithData(4, 1, 400);
        theGraph.addEdgeSingleWithData(4, 2, 0);
        theGraph.addEdgeSingleWithData(4, 3, 50);

        theGraph.printAdjMat();
    }

}
