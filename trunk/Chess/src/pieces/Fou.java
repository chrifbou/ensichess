package pieces;

import game.Table;

import java.util.ArrayList;

import utils.Pair;

public class Fou extends Piece {

	public Fou(int a, int b, int c) {
		super(a, b, c);
	}

	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> P = new ArrayList<Pair>();
		int i = this.getI();
		int j = this.getJ();
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
