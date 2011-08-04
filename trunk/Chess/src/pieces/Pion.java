package pieces;

import java.util.ArrayList;

import utils.Pair;

public class Pion extends  Piece{

	public Pion(int h, int k,int c) {
		super(h, k, c);
		type=Piece.PION;
	}

	public void affiche(){
		System.out.print("Pion : ");
		super.affiche();
	}
	@Override
	public ArrayList<Pair> possibles(game.Table T) {
		ArrayList<Pair> P=new ArrayList<Pair>();
		int i=this.getI(); int j= this.getJ();
		if (this.getCouleur()==Piece.COULEUR_NOIRE)//noir
		{
			if(T.getPos(i,j+1)==null){
			P.add(new Pair(i, j+1));
			}
			if ((T.getPos(i+1,j+1)!=null)&& (T.getPos(i+1,j+1).getCouleur()==Piece.COULEUR_BLANCHE))
				P.add(new Pair(i+1,j+1));
			
			if ((T.getPos(i-1,j+1)!=null)&& (T.getPos(i-1,j+1).getCouleur()==Piece.COULEUR_BLANCHE))
				P.add(new Pair(i-1,j+1));
		}else {
			
				if(T.getPos(i,j-1)==null)
				P.add(new Pair(i, j-1));
				
				if ((T.getPos(i+1,j-1)!=null)&& (T.getPos(i+1,j-1).getCouleur()==Piece.COULEUR_BLANCHE))
					P.add(new Pair(i+1,j-1));
				
				if ((T.getPos(i-1,j-1)!=null)&& (T.getPos(i-1,j-1).getCouleur()==Piece.COULEUR_BLANCHE))
					P.add(new Pair(i+1,j-1));
			
		}
		return P;
		
	}

	
}
