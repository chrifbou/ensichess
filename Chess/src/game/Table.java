package game;
import java.util.ArrayList;

import pieces.Piece;
import pieces.Roi;
import utils.Pair;
public class Table {
private Piece[] pieces;  //un tableau qui contient les pieces

public Piece getPos(int i,int j){
	for (int l = 0; l<32;l++){
		if ((pieces[l].getI()==i)&&(pieces[l].getJ()==j))
			return pieces[l];
	}
	return null;
}
//public void setPos(int i, int j, Piece piece) {
//	P[i][j]=piece;
	
//}
public Table(){

}

public boolean mat(int couleur){
	Pair pos=new Pair(pieces[Piece.ROI+16*couleur].getI(),pieces[Piece.ROI+16*couleur].getJ());
	
	for (int i=1-couleur*16;i<couleur+1*16;i++){
		if (pieces[i].possibles(this).contains(pos)){
			return true;
		}
	}
	return false;
	
}

}
