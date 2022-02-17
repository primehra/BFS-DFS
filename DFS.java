import java.util.ArrayList;
import java.util.List;

public class DFS {

    private ReadData data;
    private int[][] matrix;
    private int sourceNode;
    private List<Integer> discovered;
    private boolean[] visited;

    public DFS(String path, int sourceNode) {
        data = new ReadData(path);
        data.readFile();
        matrix = data.returnMatrix();
        this.sourceNode = sourceNode;
        discovered = new ArrayList<>();
        visited = new boolean[matrix.length];
        implementDFS(sourceNode);

    }

    public void implementDFS(int currNode) {

        // add current node to discovered list and mark it as visited
        discovered.add(currNode);
        visited[currNode] = true;

        for (int i = 0; i < matrix[currNode].length; i++) {
            // iterate through the current node's row in the adjacency matrix
            // if a node has not already been visited recursively implement DFS again
            if (matrix[currNode][i] == 1 && !visited[i]) {
                implementDFS(i);

            }
        }
    }

    // prints out list of nodes in the order they were discovered
    public void printDiscovered() {
        for (int i = 0; i < discovered.size(); i++) {
            System.out.println(discovered.get(i));
        }
    }

}
