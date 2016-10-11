package path;

public class Position {
	private int positionX;
	private int positionY;
	
	
	public int getX() {
		return positionX;
	}
	
	public int getY() {
		return positionY;
	}
	
	public Position(int x, int y) {
		positionX = x;
		positionY = y;
	}
	
	public static Position add(Position a, Position b){
		return new Position(a.getX()+b.getX(), a.getY()+b.getY());
	}
	
	public String toString(){
		return "("+this.getX()+","+this.getY()+")";
	}

}
