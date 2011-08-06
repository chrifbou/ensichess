package pieces;

import game.Table;

import java.util.ArrayList;

import utils.Pair;

public class Fou extends Piece {

	public Fou(int a, int b, int c) {
		super(a, b, c);
		type = Piece.FOU;
	}

	public void affiche() {
		System.out.print("FOU : ");
		super.affiche();
	}

	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> P = new ArrayList<Pair>();
		int i = this.getI();
		int j = this.getJ();
		for (int k = 1; (k + i < 8) && (k + j < 8); k++) { // diagoanle vers le
															// haut droite
			if (T.getPos(i + k, j + k) != null) {
				if (T.getPos(i + k, j + k).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j + k));
				break;
			} else
				P.add(new Pair(i + k, j + k));
		} // fin diagonale vers le haut droite

		for (int k = 1; (i - k >= 0) && (k + j < 8); k++) { // diagonale vers le
															// haut gauche
			if (T.getPos(i - k, j + k) != null) {
				if (T.getPos(i - k, j + k).getCouleur() != this.getCouleur())
					P.add(new Pair(i - k, j + k));
				break;
			} else
				P.add(new Pair(i - k, j + k));

		} // fin diagonale vers le haut gauche

		for (int k = 1; (i + k < 8) && (j - k >= 0); k++) { // diagonale vers le
															// bas droite
			if (T.getPos(i + k, j - k) != null) {
				if (T.getPos(i + k, j - k).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j - k));
				break;
			} else
				P.add(new Pair(i + k, j - k));

		} // fin diagonale vers le bas droite

		for (int k = 1; (i - k >= 0) && (j - k >= 0); k++) { // diagonale vers
																// le bas gauche
			if (T.getPos(i - k, j - k) != null) {
				if (T.getPos(i - k, j - k).getCouleur() != this.getCouleur())
					P.add(new Pair(i - k, j - k));
				break;
			} else
				P.add(new Pair(i - k, j - k));

		} // diagonale vers le bas gauche

		return P;
	}

}
