
public abstract class RobotPollueur extends Robot {
	
	public RobotPollueur(int x, int y, Monde m) {
		super(x, y, m);
	}
	
	public RobotPollueur(Monde m) {
		super(m);
	}
	
	public void polluer() {
		super.getMonde().metPapierGras(super.getPosx(), super.getPosy());
	}
	
}
