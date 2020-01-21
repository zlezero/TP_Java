
public class PollueurSauteur extends RobotPollueur {
	
	private int deltax;
	
	public PollueurSauteur(int x, int y, Monde m, int deltax) {
		super(x, y, m);
		this.deltax = deltax;
	}
	
	public PollueurSauteur(Monde m, int deltax) {
		super(m);
		this.deltax = deltax;
	}

	public void parcourir() {
		
		super.vaEn(0, 0);
		
		for (int i = 0; i < this.getMonde().getNbL(); i++) {
			
			this.vaEn(i, (deltax * i) % this.getMonde().getNbC());
			this.polluer();
			
		}
		
	}
	
}
