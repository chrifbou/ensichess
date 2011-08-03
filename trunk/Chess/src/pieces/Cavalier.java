package pieces;

import game.Table;

import java.util.ArrayList;

import utils.Pair;

public class Cavalier extends Piece {

	public Cavalier(int h, int k, int c) {
		super(h, k, c);

	}



	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> P= new ArrayList<Pair>();
		int i=this.getI();int j=this.getJ();
		if (i+2<8){
			if (j+1<8)
				P.add(new Pair(i+2,j+1));
			if (j-1>=0)
				P.add(new Pair(i+2,j-1));
		}
		if (i-2>=0){
			if (j+1<8)
				P.add(new Pair(i-2,j+1));
			if (j-1>=0)
				P.add(new Pair(i-2,j-1));
		}
		if (j-2>=0){
			if (i+1<8)
				P.add(new Pair(i+1,j-2));
			if (i-1>=0)
				P.add(new Pair(i-1,j-2));
		}
		if (j+2>=0){
			if (i+1<8)
				P.add(new Pair(i+1,j+2));
			if (i-1>=0)
				P.add(new Pair(i-1,j+2));
		}
		return P;
	}

}
