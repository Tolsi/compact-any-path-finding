/**
 * Instructions: Look for the main method.
 * We can either run tests or trace the algorithm.
 * <p>
 * To see a visualisation of an algorithm,
 * 1) Set choice = 0 in the first line of main();
 * 2) Choose a maze in the first line of loadMaze();
 * 3) Choose an algorithm in the first line of setDefaultAlgoFunction();
 * <p>
 * The tracing / experimentation functions are detailed in the traceAlgorithm() method.
 */
public class AAPFAnyAnglePathfinding {

    /**
     * Choose a maze. (a gridGraph setting)
     */
    static AAPFGridAndGoals loadMaze() {
        int choice = 1; // Adjust this to choose a maze.

        switch (choice) {
            case 0: {// UNSEEDED
                int unblockedRatio = 10;      // chance of spawning a cluster of blocked tiles is 1 in unblockedRatio.
                int sizeX = 20;               // x-axis size of grid
                int sizeY = 20;               // y-axis size of grid

                int sx = 10;                  // x-coordinate of start point
                int sy = 13;                  // y-coordinate of start point
                int ex = 6;                   // x-coordinate of goal point
                int ey = 8;                   // y-coordinate of goal point
                return AAPFDefaultGenerator.generateUnseeded(sizeX, sizeY, unblockedRatio, sx, sy, ex, ey);
            }
            case 1: { // SEEDED
                int unblockedRatio = 17;      // chance of spawning a cluster of blocked tiles is 1 in unblockedRatio.
                int seed = 1667327427;        // seed for the random.

                int sizeX = 40;               // x-axis size of grid
                int sizeY = 40;               // y-axis size of grid
                int sx = 6;                   // x-coordinate of start point
                int sy = 10;                  // y-coordinate of start point
                int ex = 39;                  // x-coordinate of goal point
                int ey = 32;                  // y-coordinate of goal point
                return AAPFDefaultGenerator.generateSeeded(seed, sizeX, sizeY, unblockedRatio, sx, sy, ex, ey);
            }
            case 2:
                return AAPFDefaultGenerator.generateSeededOld(-98783479, 40, 40, 7, 1, 4, 18, 18); // maze 3
            case 3:
                return AAPFDefaultGenerator.generateSeededOld(-565315494, 15, 15, 9, 1, 2, 1, 13); // maze 2
            case 4:
                return AAPFDefaultGenerator.generateSeededOld(53, 15, 15, 9, 0, 0, 10, 14); // maze 1
            default :
                return null;
        }
    }
}
