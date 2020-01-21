
public class NettoyeurDistrait extends RobotNettoyeur {
	
	public NettoyeurDistrait(int x, int y, Monde m) {
		super(x, y, m);
	}
	
	public NettoyeurDistrait(Monde m) {
		super(m);
	}
	
	public void parcourir() {
		
		int compteur = 1;
		int j = 0;

		super.vaEn(0, 0);	
			
		for (int i = 0; i < super.getMonde().getNbL();) {
						
			for (j = 0; j < super.getMonde().getNbC(); j++) {	
				
				super.vaEn(i, j);
				
				if (compteur % 2 == 0) {
					super.nettoyer();
				}
								
				compteur++;
				
			}
			
			i++;
						
			for (j = super.getMonde().getNbC() - 1; j >= 0; j--) {		
				
				super.vaEn(i, j);
				
				if (compteur % 2 == 0) {
					super.nettoyer();
				}
								
				compteur++;
				
			}
			
			i++;
						
		}
		
	}
	
}
