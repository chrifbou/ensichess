package game;

import utils.Pair;
import pieces.*;
public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table T=new Table();
		
		
		
		
		System.out.println();
		T.supprimer(3,1);
		T.supprimer(3, 6);
		//T.supprimer(4, 0);
		T.getPos(4, 7).move(T, new Pair(3,6));
		//T.getPos(3, 6).move(T, new Pair(3,1));
		
		//T.getPos(4, 7).move(T, new Pair(3,6));
		//T.getPos(3, 6).affichePoss(T);
		//T.getPos(1,0).affichePoss(T);
		//T.affiche();
		
		System.out.println(T.echecEtMate(Piece.COULEUR_BLANCHE));
		System.out.println(T.echecEtMate(Piece.COULEUR_NOIRE));
		
		
	}

}
