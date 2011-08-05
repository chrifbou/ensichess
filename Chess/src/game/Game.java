package game;

import utils.Pair;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table T =new Table();
		
		T.affiche();
		System.out.println();
		T.supprimer(7,1);
		T.supprimer(5, 0);
		T.supprimer(6, 0);
		T.getPos(7, 0).affichePoss(T);
		T.getPos(7, 0).move(T, new Pair(7,3));
		T.getPos(7, 3).affichePoss(T);
		//*/
	}

}
package game;

import utils.Pair;

public class Game {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Table T=new Table();
		T.affiche();
		System.out.println();
		T.supprimer(7,1);
		T.supprimer(5, 0);
		T.supprimer(6, 0);
		//T.getPos(7, 0).affichePoss(T);
		T.getPos(7, 0).move(T, new Pair(7,3));
		T.getPos(7, 3).affichePoss(T);
		
	}

}
