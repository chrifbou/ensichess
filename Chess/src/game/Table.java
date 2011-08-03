package game;
import pieces.Piece;
public class Table {
private Piece[][] P;
public Piece getPos(int i,int j){
	return P[i][j];
}
public void setPos(int i, int j, Piece piece) {
	P[i][j]=piece;
	
}
public Table(){
	
}
}
