
public class TestData {

    public static void main(String[] args) {
        BFS sampleBFS = new BFS ("facebook_combined.txt", 34);
        DFS sampleDFS = new DFS ("facebook_combined.txt", 34);

        System.out.println(sampleBFS.getTotalFrontiers());
        System.out.println(sampleBFS.distanceWithin(4, 1344));

    }
}
