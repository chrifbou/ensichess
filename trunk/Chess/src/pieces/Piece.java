package pieces;

import java.util.ArrayList;
import game.Table;
import utils.Pair;

public abstract class Piece {

	private int i;
	private int j;
	private int couleur;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getCouleur() {
		return couleur;
	}
	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	
	public abstract ArrayList<Pair> possibles(game.Table T);
		
	public Piece(int h,int k,int c){
		i=h;
		j=k;
		couleur=c;
	}
	public void affiche() {
		ArrayList<Pair> d=new ArrayList<Pair>();
		//d=this.possibilitees();
		for(int i=0;i<d.size();i++)
		System.out.println(d.get(i).i+"  "+d.get(i).j);
	}
	public Piece(){
		i=0;j=0;
	}
	
	public void move(Table T,Pair p){
		ArrayList<Pair> liste= this.possibles(T);
		if (liste.contains(p)){
			T.setPos(p.i,p.j,this);
			T.setPos(i, j, null);
			i=p.i;
			j=p.j;
		}
	}
	
	public static int COULEUR_NOIRE=0;
	public static int COULEUR_BLANCHE=1;
}
