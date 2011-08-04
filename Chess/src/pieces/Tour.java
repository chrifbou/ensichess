package pieces;

import game.Table;

import java.util.ArrayList;

import utils.Pair;

public class Tour extends Piece {

	public Tour(int h, int k, int c) {
		super(h, k, c);
		type=Piece.TOUR;
	}
	public void affiche(){
		System.out.print("TOUR : ");
		super.affiche();
	}


	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> P= new ArrayList<Pair>();
		int i=this.getI();int j=this.getJ();
		for (int k=1;k+i<8;k++){                     //Horizontale vers la droite
			if (T.getPos(i + k, j ) != null) {
				if (T.getPos(i + k, j ).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j));
				break;
			}else P.add(new Pair(i + k, j ));
		}                            // fin horizontale vers la droite
		
		for (int k=-1;k+i>=0;k--){					//horizontale vers le gauche
			if (T.getPos(i + k, j ) != null) {
				if (T.getPos(i + k, j ).getCouleur() != this.getCouleur())
					P.add(new Pair(i + k, j));
				break;
			}else P.add(new Pair(i + k, j ));
		}  											//fin horizontale vers la gauche
		for (int k=1;k+j<8;k++){                            //verticale vers le haut
			if (T.getPos(i , j+k ) != null) {
				if (T.getPos( i, j+k ).getCouleur() != this.getCouleur())
					P.add(new Pair( i, j+k));
				break;
			}else P.add(new Pair(i, j+k ));
		}													//fin verticale vers le haut
		
		for (int k=-1;k+j>=0;k--){                  //verticale vers le bas
			if (T.getPos(i , j+k ) != null) {
				if (T.getPos( i, j+k ).getCouleur() != this.getCouleur())
					P.add(new Pair( i, j+k));
				break;
			}else P.add(new Pair(i, j+k ));
		}   										//verticale vers le bas
		
		
		return P;
	}

}
