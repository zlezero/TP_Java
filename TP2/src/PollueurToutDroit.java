
public class PollueurToutDroit extends RobotPollueur {

	private int colDepart;

	public PollueurToutDroit(int x, int y, Monde m, int colDepart) {
		super(x, y, m);
		this.colDepart = colDepart;
	}
	
	public PollueurToutDroit(Monde m, int colDepart) {
		super(m);
		this.colDepart = colDepart;
	}
	
	public void parcourir() {
		
		for (int i = 0; i < super.getMonde().getNbL(); i++) {
			super.vaEn(i, colDepart);
			super.polluer();
		}
		
	}
	
	public int getColDepart() {
		return colDepart;
	}

	public void setColDepart(int colDepart) {
		this.colDepart = colDepart;
	}
	
}
