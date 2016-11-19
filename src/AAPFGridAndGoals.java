/**
 * A problem instance - a AAPFGridGraph and the Start, Goal points.
 */
public class AAPFGridAndGoals {
	public final AAPFGridGraph gridGraph;
	public final AAPFStartGoalPoints startGoalPoints;
	
	public AAPFGridAndGoals(AAPFGridGraph gridGraph, AAPFStartGoalPoints startGoalPoints) {
		this.gridGraph = gridGraph;
		this.startGoalPoints = startGoalPoints;
	}
	
	public AAPFGridAndGoals(AAPFGridGraph gridGraph, int sx, int sy, int ex, int ey) {
		this.gridGraph = gridGraph;
		this.startGoalPoints = new AAPFStartGoalPoints(sx, sy, ex, ey);
	}
}
