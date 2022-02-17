import java.io.FileNotFoundException;

import java.util.Scanner;
import java.io.File;

public class ReadData {

    private int[][] adjacencyMatrix;
    private File facebookData;
    private Scanner read;
    private Scanner size;

    public ReadData(String path) {
        int arraySize = 0;
        try {
            facebookData = new File(path);
            size = new Scanner(facebookData);
            read = new Scanner(facebookData);
            // finds the max node and makes that the array size
            while(size.hasNextInt()) {
                int compare = size.nextInt();
                if (compare > arraySize) {
                    arraySize = compare;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        // initializes matrix to all 0's using size found above
        adjacencyMatrix = new int[arraySize+1][arraySize+1];
        for (int i = 0; i < adjacencyMatrix.length; i ++){
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

    }

    // reads in data from file and fills in adjacency matrix
    public void readFile() {
        read = read.reset();
        while(read.hasNextInt()) {
            int from = read.nextInt();
            int to = read.nextInt();
            adjacencyMatrix[from][to] = 1;
            adjacencyMatrix[to][from] = 1;
        }
    }

    // returns adjacency matrix
    public int[][] returnMatrix() {
        return adjacencyMatrix;
    }

    public static void main(String[] args) {

    }

}
