
public class RobotNettoyeur extends Robot {
	
	public RobotNettoyeur(int x, int y, Monde m) {
		super(x, y, m);
	}
	
	public RobotNettoyeur(Monde m) {
		super(m);
	}
	
	public void nettoyer() {
		super.getMonde().prendPapierGras(super.getPosx(), super.getPosy());
	}

	public void parcourir() {
		
		super.vaEn(0, 0);
		
		int j = 0;
		
		for (int i = 0; i < super.getMonde().getNbL(); i++) {
			
			for (j = 0; j < super.getMonde().getNbC(); j++) {	
				super.vaEn(i, j);
				nettoyer();
			}
			
			for (j = super.getMonde().getNbC(); j >= 0; j--) {		
				super.vaEn(i, j);
				nettoyer();
			}
						
		}
		
	}
	
}
