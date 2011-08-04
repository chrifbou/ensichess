package pieces;

import game.Table;

import java.util.ArrayList;

import utils.Pair;

public class Dame extends Piece {

	public Dame(int h, int k, int c) {
		super(h, k, c);
		type=Piece.DAME;
	}
	

	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> P= new ArrayList<Pair>();
		int i=this.getI();int j=this.getJ();
		for (int k=1;k+i<8;k++){
			if (T.getPos(i + k, j ) != null) {
				if (T.getPos(i + k, j ).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j));
				break;
			}
			P.add(new Pair(i + k, j ));
		}
		for (int k=-1;k+i>=0;k--){
			if (T.getPos(i + k, j ) != null) {
				if (T.getPos(i + k, j ).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j));
				break;
			}
			P.add(new Pair(i + k, j ));
		}
		for (int k=1;k+j<8;k++){
			if (T.getPos(i , j+k ) != null) {
				if (T.getPos( k, j+k ).getCouleur() != this.getCouleur())
					P.add(new Pair( k, j+k));
				break;
			}
			P.add(new Pair(i, j+k ));
		}
		for (int k=-1;k+j>=0;k--){
			if (T.getPos(i , j+k ) != null) {
				if (T.getPos( k, j+k ).getCouleur() != this.getCouleur())
					P.add(new Pair( k, j+k));
				break;
			}
			P.add(new Pair(i, j+k ));
		}
		
		for (int k = 1; (k + i < 8) && (k + j < 8); k++) {
			if (T.getPos(i + k, j + k) != null) {
				if (T.getPos(i + k, j + k).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j + k));
				break;
			}
			P.add(new Pair(i + k, j + k));
		}
		for (int k = 1; (i - k >= 0) && (k + j < 8); k++) {
			if (T.getPos(i - k, j + k) != null){
				if (T.getPos(i - k, j + k).getCouleur() != this.getCouleur())
					P.add(new Pair(i - k, j + k));
				break;
			}
			P.add(new Pair(i - k, j + k));
			
		}
		for (int k = 1; (i + k < 8) && (j - k >= 0); k++) {
			if (T.getPos(i + k, j - k) != null){
				if (T.getPos(i + k, j - k).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j - k));
				break;
			}
			P.add(new Pair(i - k, j + k));
			
		}
		
		
		for (int k = 1; (i - k >= 0) && (j - k >= 0); k++) {
			if (T.getPos(i - k, j - k) != null){
				if (T.getPos(i - k, j - k).getCouleur() != this.getCouleur())
					P.add(new Pair(i - k, j - k));
				break;
			}
			P.add(new Pair(i - k, j - k));
			
		}
		
		return P;
	}

}