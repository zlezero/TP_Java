public abstract class Robot {

	private int posx;
	private int posy;
	private Monde m;
	
	public Robot(int x, int y, Monde m) {
		posx = x;
		posy = y;
		this.m = m;
	}
	
	public Robot(Monde m) {
		this((int)(Math.random() * ((m.getNbC()) + 1)), (int)(Math.random() * ((m.getNbL()) + 1)), m);
	}
	
	public boolean vaEn(int i, int j) {
		
		if (i < m.getNbC() && j < m.getNbL()) {
			posx = i;
			posy = j;
			return true;
		}
		else 
			return false;

	}
	
	public abstract void parcourir();
	
	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}

	public Monde getMonde() {
		return m;
	}
	
}
