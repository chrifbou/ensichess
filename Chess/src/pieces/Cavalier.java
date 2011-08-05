package pieces;

import game.Table;

import java.util.ArrayList;

import utils.Pair;

public class Cavalier extends Piece {

	public Cavalier(int h, int k, int c) {
		super(h, k, c);
		type=Piece.CAVALIER;
	}

	public void affiche(){
		System.out.print("Cavalier: ");
		super.affiche();
	}

	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> P= new ArrayList<Pair>();
		int i=this.getI();int j=this.getJ();int c=this.getCouleur();
		if (i+2<8){
			if (j+1<8 && c!=T.getPos(i+2,j+1).getCouleur())
				P.add(new Pair(i+2,j+1));
			if (j-1>=0 && c!=T.getPos(i-1,j-1).getCouleur())
				P.add(new Pair(i+2,j-1));
		}
		if (i-2>=0){
			if (j+1<8 && c!=T.getPos(i-2,j+1).getCouleur())
				P.add(new Pair(i-2,j+1));
			if (j-1>=0 && c!=T.getPos(i-2,j-1).getCouleur())
				P.add(new Pair(i-2,j-1));
		}
		if (j-2>=0){
			if (i+1<8 && c!=T.getPos(i+1,j-2).getCouleur())
				P.add(new Pair(i+1,j-2));
			if (i-1>=0 && c!=T.getPos(i-1,j-2).getCouleur())
				P.add(new Pair(i-1,j-2));
		}
		if (j+2>=0){
			if (i+1<8 && c!=T.getPos(i+1,j+2).getCouleur())
				P.add(new Pair(i+1,j+2));
			if (i-1>=0 && c!=T.getPos(i-1,j+2).getCouleur())
				P.add(new Pair(i-1,j+2));
		}
		return P;
	}

}
