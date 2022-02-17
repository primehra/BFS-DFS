import java.util.ArrayList;
import java.util.List;

public class BFS {

    private ReadData data;                  // instance of ReadData class
    private int[][] matrix;                 // adjacency matrix
    private int sourceNode;                 // starting node
    private List<Integer> queue;            // queue of nodes to be visited
    private List<Integer> discovered;       // list of discovered nodes
    private int totalFrontiers;             // total number of frontiers
    private boolean[] visited;              // array indicating whether node has been visited
    private int[] discoveredLevel;          // array indicating frontier of each node


    public BFS(String path, int sourceNode) {
        data = new ReadData(path);
        data.readFile();
        matrix = data.returnMatrix();
        this.sourceNode = sourceNode;
        queue = new ArrayList<>();
        discovered = new ArrayList<>();
        discovered.add(sourceNode);
        queue.add(sourceNode);
        totalFrontiers = 0;
        visited = new boolean[matrix.length];
        discoveredLevel = new int[matrix.length];
        discoveredLevel[sourceNode] = 0;
        implementBFS();


    }

    // returns frontier of given node
    public int findDistance(int distanceTo) {
        return discoveredLevel[distanceTo];
    }

    //checks whether all nodes have been visited
    public boolean allVisited() {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    // returns total number of frontiers
    public int getTotalFrontiers() {
        return totalFrontiers;
    }

    // prints out list of all nodes and corresponding frontiers
    public void checkFrontiers() {
        for (int i = 0; i < discoveredLevel.length; i++) {
            System.out.println(i + " " + discoveredLevel[i]);
        }
    }

    // returns number of nodes within a certain distance of a given node
    public int distanceWithin(int distance, int node) {
        int minDistance = discoveredLevel[node] - distance;
        int maxDistance = discoveredLevel[node] + distance;

        int nodesWithin = 0;
        for (int i = 0; i < discoveredLevel.length; i++){
            if (i != node && discoveredLevel[i] >= minDistance && discoveredLevel[i] <= maxDistance) {

                nodesWithin++;
            }
        }
        return nodesWithin;
    }


    public void implementBFS() {

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[sourceNode] = true;
        int curr = sourceNode;
        // loop until all nodes are visited

            while(!queue.isEmpty()) {
                // remove first item from queue and make it current node
                curr = queue.get(0);
                queue.remove(0);
                // find all neighbors
                for (int i = 0; i < matrix[curr].length; i++) {

                    if (matrix[curr][i] == 1 && !visited[i]) {
                        // add neighbor to queue and discovered, mark it visited
                        queue.add(i);
                        discovered.add(i);
                        visited[i] = true;
                        // make frontier of neighbor one more than parent node
                        discoveredLevel[i] = discoveredLevel[curr] + 1;
                        // sets total number of frontiers to new frontier of neighbor
                        totalFrontiers = discoveredLevel[i];

                    }
                }



        }
    }

}
