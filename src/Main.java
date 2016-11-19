public class Main {

    public static void main(String[] args) {
        AAPFAlgoFunction algo = AAPFBasicThetaStar::postSmooth;
        AAPFGridAndGoals gridAndGoals = AAPFAnyAnglePathfinding.loadMaze();
        int[][] path = AAPFUtility.generatePath(algo, gridAndGoals.gridGraph, gridAndGoals.startGoalPoints.sx, gridAndGoals.startGoalPoints.sy, gridAndGoals.startGoalPoints.ex, gridAndGoals.startGoalPoints.ey);
        System.out.println(path);
    }
}
