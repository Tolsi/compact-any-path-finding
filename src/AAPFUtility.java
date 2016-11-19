import java.util.Arrays;

public class AAPFUtility {

    /**
     * Compute the length of a given path. (Using euclidean distance)
     */
    public static double computePathLength(AAPFGridGraph gridGraph, int[][] path) {
        path = removeDuplicatesInPath(path);
        double pathLength = 0;
        for (int i=0; i<path.length-1; i++) {
            pathLength += gridGraph.distance_double(path[i][0], path[i][1],
                            path[i+1][0], path[i+1][1]);
        }
        return pathLength;
    }

    public static int[][] removeDuplicatesInPath(int[][] path) {
        if (path.length <= 2) return path;

        int[][] newPath = new int[path.length][];
        int index = 0;
        newPath[0] = path[0];
        for (int i=1; i<path.length-1; ++i) {
            if (isCollinear(path[i][0], path[i][1], path[i+1][0], path[i+1][1], newPath[index][0], newPath[index][1])) {
                // skip
            } else {
                index++;
                newPath[index] = path[i];
            }
        }
        index++;
        newPath[index] = path[path.length-1];
        return Arrays.copyOf(newPath, index+1);
    }

    private static boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y3-y1)*(x2-x1) == (x3-x1)*(y2-y1);
    }
    
    /**
     * Generates a path between two points on a grid.
     * @return an array of int[2] indicating the coordinates of the path.
     */
    public static int[][] generatePath(AAPFAlgoFunction algoFunction, AAPFGridGraph gridGraph,
                                       int sx, int sy, int ex, int ey) {
        AAPFPathFindingAlgorithm algo = algoFunction.getAlgo(gridGraph, sx, sy, ex, ey);
        algo.computePath();
        
        int[][] path = algo.getPath();
        return path;
    }
    
    public static boolean isPathTaut(AAPFGridGraph gridGraph, int[][] path) {
        int v1 = 0;
        int v2 = 1;
        for (int v3=2; v3<path.length; ++v3) {
            if (!gridGraph.isTaut(path[v1][0], path[v1][1], path[v2][0], path[v2][1], path[v3][0], path[v3][1])) return false;
            ++v1;
            ++v2;
        }
        return true;
    }

    public static boolean isOptimal(double length, double optimalLength) {
        //System.out.println(length + " | " + optimalLength + " | " + ((length - optimalLength) < 0.0001)); 
        return (length - optimalLength) < 0.0001;
    }
}
