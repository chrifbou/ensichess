package game;

import java.util.ArrayList;

import pieces.*;
import utils.Pair;

public class Table {
	public Piece[] pieces = new Piece[32]; // un tableau qui contient les pieces

	public Piece getPos(int i, int j) {
		for (int l = 0; l < 32; l++) {
			if ((pieces[l] != null) && (pieces[l].getI() == i)
					&& (pieces[l].getJ() == j))
				return pieces[l];
		}
		return null;
	}

	// public void setPos(int i, int j, Piece piece) {
	// P[i][j]=piece;

	// }
	public Table() {

		pieces[0] = new Roi(3, 0, Piece.COULEUR_NOIRE);
		pieces[1] = new Dame(4, 0, Piece.COULEUR_NOIRE);
		pieces[2] = new Fou(2, 0, Piece.COULEUR_NOIRE);
		pieces[3] = new Fou(5, 0, Piece.COULEUR_NOIRE);
		pieces[4] = new Cavalier(1, 0, Piece.COULEUR_NOIRE);
		pieces[5] = new Cavalier(6, 0, Piece.COULEUR_NOIRE);
		pieces[6] = new Tour(7, 0, Piece.COULEUR_NOIRE);
		pieces[7] = new Tour(0, 0, Piece.COULEUR_NOIRE);
		for (int i = 8; i < 16; i++)
			pieces[i] = new Pion(i - 8, 1, Piece.COULEUR_NOIRE);

		pieces[16] = new Roi(3, 7, Piece.COULEUR_BLANCHE);
		pieces[17] = new Dame(4, 7, Piece.COULEUR_BLANCHE);
		pieces[18] = new Fou(2, 7, Piece.COULEUR_BLANCHE);
		pieces[19] = new Fou(5, 7, Piece.COULEUR_BLANCHE);
		pieces[20] = new Cavalier(1, 7, Piece.COULEUR_BLANCHE);
		pieces[21] = new Cavalier(6, 7, Piece.COULEUR_BLANCHE);
		pieces[22] = new Tour(7, 7, Piece.COULEUR_BLANCHE);
		pieces[23] = new Tour(0, 7, Piece.COULEUR_BLANCHE);
		for (int i = 8; i < 16; i++)
			pieces[i + 16] = new Pion(i - 8, 6, Piece.COULEUR_BLANCHE);

	}

	public boolean mat(int couleur) {
		Pair pos = new Pair(pieces[Piece.ROI + 16 * couleur].getI(),
				pieces[Piece.ROI + 16 * couleur].getJ());

		for (int i = (1 - couleur) * 16; i < (-couleur + 2) * 16; i++) {
			if ((pieces[i] != null)
					&& (pieces[i].possibles(this).contains(pos))) {

				return true;
			}

		}
		return false;

	}

	public void supprimer(int i, int j) {
		for (int l = 0; l < 32; l++) {
			if (((pieces[l] != null) && pieces[l].getI() == i)
					&& (pieces[l].getJ() == j)) {
				pieces[l] = null;
				break;
			}
		}
	}

	public void affiche() {
		for (int i = 0; i < 32; i++)
			if (pieces[i] != null) {
				pieces[i].affiche();
			}
	}

	public boolean echecEtMate(int Couleur) {
		Table T2;
		if (!mat(Couleur)) {
			return false;
		}
		ArrayList<Pair> Poss = pieces[Couleur*16].possibles(this);
		for (int i = 0; i < Poss.size(); i++) {
			T2 = new Table(this);
			pieces[Couleur*16].move(T2, Poss.get(i));
			if (!T2.mat(Couleur)) {
				return false;
			}
		}

		return true;
	}

	public Table(Table T) {
		for (int i = 0; i < 32; i++)
			this.pieces[i] = T.pieces[i];
	}

}
