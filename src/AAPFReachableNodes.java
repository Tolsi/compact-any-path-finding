import java.util.ArrayList;

public class AAPFReachableNodes extends AAPFBreadthFirstSearch {

    private AAPFReachableNodes(AAPFGridGraph graph, int sx, int sy, int ex,
                               int ey) {
        super(graph, sx, sy, ex, ey);
    }
    
    /**
     * Computes the set of all nodes reachable from (sx,sy) by an unblocked path.
     * @param graph the grid to use.
     * @param sx x-coordinate of root node
     * @param sy y-coordinate of root node
     * @return An ArrayList of AAPFPoint objects (nodes reachable from (sx,sy) via an unblocked path).
     */
    public static ArrayList<AAPFPoint> computeReachable(AAPFGridGraph graph, int sx, int sy) {
        AAPFReachableNodes nodes = new AAPFReachableNodes(graph, sx, sy, -10, -10);
        ArrayList<AAPFPoint> list = new ArrayList<>();

        nodes.computePath();
        for (int i=0; i<nodes.visited.length; i++) {
            if (nodes.visited[i]) {
                int x = nodes.toTwoDimX(i);
                int y = nodes.toTwoDimY(i);
                list.add(new AAPFPoint(x, y));
            }
        }
        
        return list;
    }

}
