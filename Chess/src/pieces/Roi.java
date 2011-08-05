package pieces;

import game.Table;

import java.util.ArrayList;
import utils.Pair;

public class Roi extends Piece {

	public Roi(int i, int j, int cOULEUR_NOIRE) {
		super(i, j, cOULEUR_NOIRE);
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
		if(i>0){
			p.add(new Pair(i-1,j));
			if(j<7) p.add(new Pair(i-1,j+1));
			if(j>0) p.add(new Pair(i-1,j-1));
		}
		if(i<7){
			p.add(new Pair(i+1,j));
			if(j<7) p.add(new Pair(i+1,j+1));
			if(j>0) p.add(new Pair(i+1,j-1));
		}
		if(j<7) p.add(new Pair(i,j+1));
		if(j>0) p.add(new Pair(i,j-1));
		//verifier si j'ai utilise i et j ou nn
		i=16*this.getCouleur();
		while(i<16+16*this.getCouleur() && p.isEmpty()==false){
			ArrayList<Pair> pa=Table.pieces[this.getCouleur()].possibles(T);
			for(j=0;j<pa.size();j++) if(p.contains(pa.get(j))) {
				boolean test=true;
				byte k=0;
				while(test&&k<p.size()){
					if(p.get(k)==pa.get(j)){
						p.remove(k);
						test=false;
					}
				}
			}
			i++;
		}
		
		return p;
	}
}
