
public class PollueurSauteur extends RobotPollueur {
	
	private int deltax;
	
	public PollueurSauteur(int x, int y, Monde m) {
		super(x, y, m);
	}
	
	public PollueurSauteur(Monde m) {
		super(m);
	}

	public void parcourir() {
		super.vaEn(0, 0);
		int compteur = 0;
		while (super.getPosx() != super.getMonde().getNbC()) {
			super.vaEn(compteur, compteur * deltax);
			deltax += 1;
			compteur += 1;
			if (deltax > super.getMonde().getNbC()) {
				deltax %= super.getPosx();
			}
		}
	}
	
}
