package pieces;

import game.Table;

import java.util.ArrayList;
import utils.Pair;

public class Roi extends Piece {

	public Roi(int h, int k,int c) {
		super(h, k, c);
		type=Piece.ROI;
	
	}

	
	



	@Override
	public ArrayList<Pair> possibles(Table T) {
		ArrayList<Pair> p = new ArrayList<Pair>();
		int i=this.getI();
		int j=this.getJ();
		if (i>=0){
			p.add(new Pair(i-1,j));
		
			if(j>=0){
				p.add(new Pair(i-1,j-1));
			}
			if (j<7){
				p.add(new Pair(i-1,j+1));
			}
		}
		if (j>=0){
			p.add(new Pair(i,j-1));
			if (i<7){
				p.add(new Pair(i+1,j-1));
			}
		}
		if (i<7){
			p.add(new Pair(i+1,j));
			if(j<7){
				p.add(new Pair(i+1,j+1));
			}
		}
		if(j<7){
			p.add(new Pair(i,j+1));
		}
		
		
		
		
		return p;
	}
	}
