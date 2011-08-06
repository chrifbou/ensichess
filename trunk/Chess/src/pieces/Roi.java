package pieces;

import game.Table;

import java.util.ArrayList;
import utils.Pair;

public class Roi extends Piece {

	public Roi(int i, int j, int c) {
		super(i, j, c);
		type = Piece.ROI;

	}

	public void affiche() {
		System.out.print("Roi : ");
		super.affiche();
	}

	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> p = new ArrayList<Pair>();
		int i = this.getI();
		int j = this.getJ();
		int c = this.getCouleur();
		if (i > 0) {
			if ((T.getPos(i - 1, j) == null)
					|| (c != T.getPos(i - 1, j).getCouleur()))
				p.add(new Pair(i - 1, j));
			if (j < 7
					&& ((T.getPos(i - 1, j + 1) == null) || c != T.getPos(
							i - 1, j + 1).getCouleur()))
				p.add(new Pair(i - 1, j + 1));
			if (j > 0
					&& (c != T.getPos(i - 1, j - 1).getCouleur() || T.getPos(
							i - 1, j - 1) == null))
				p.add(new Pair(i - 1, j - 1));
		}
		if (i < 7) {
			if ((T.getPos(i + 1, j) == null)
					|| (c != T.getPos(i + 1, j).getCouleur()))
				p.add(new Pair(i + 1, j));
			if (j < 7
					&& ((T.getPos(i + 1, j + 1) == null) || c != T.getPos(
							i + 1, j + 1).getCouleur()))
				p.add(new Pair(i + 1, j + 1));
			if (j > 0
					&& ((T.getPos(i + 1, j - 1) == null) || c != T.getPos(
							i + 1, j - 1).getCouleur()))
				p.add(new Pair(i + 1, j - 1));
		}
		if (j < 7
				&& ((T.getPos(i, j + 1) == null) || c != T.getPos(i, j + 1)
						.getCouleur()))
			p.add(new Pair(i, j + 1));
		if (j > 0
				&& ((T.getPos(i, j - 1) == null) || c != T.getPos(i, j - 1)
						.getCouleur()))
			p.add(new Pair(i, j - 1));

		return p;
	}

	public boolean mat(Table T) {
		// 1er cas: prendre la fuite
		if (this.possibles(T).isEmpty() == false)
			return false;
		// il y a deux possibilete:soit manger l'attaquant soit
		// intercepter une piece entre l'attaquant est le roi
		else {
			int couleur = this.getCouleur();
			// 2eme cas manger l'attaquant
			// chercher mes coordonnes
			Pair pos = new Pair(T.pieces[Piece.ROI + 16 * couleur].getI(),
					T.pieces[Piece.ROI + 16 * couleur].getJ());
			// chercher les coordonnes des attaquant
			ArrayList<Pair> att = new ArrayList<Pair>();
			for (int i = 16 * couleur; i < 16 + 16 * couleur; i++) {
				if (T.pieces[i].possibles(T).contains(pos))
					att.add(new Pair(T.pieces[i].getI(), T.pieces[i].getJ()));
			}
			// voir si possibilites de manger
			for (int j = 0; j < att.size(); j++) {
				boolean test = false;
				int i = 16 * couleur + 16;
				while (i < -32 - 16 * couleur && test == false) {
					if (T.pieces[i].possibles(T).contains(att.get(j))) {
						test = true;
					}
					i++;
				}
				if (test == false) {
					// test == false cad y a un att ke je peu pa manger
					System.out.println("Echec et mat!! ");
					return true;
				}
			}

			// 3eme cas intercaler une piece
			// attention seul le cavalier ne peu pa etre intercepte
			for (int j = 0; j < att.size(); j++) {
				if ((T.getPos(att.get(j).i, att.get(j).i)).getType() == Piece.CAVALIER) {
					return true;
				} else {
					boolean test = false;
					int i = -16 * couleur + 16;
					while (i < 32 - 16 * couleur && test == false) {

					}
				}

			}
		}
		return false;
	}
}
