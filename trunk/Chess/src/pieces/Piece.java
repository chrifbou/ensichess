package pieces;

import java.util.ArrayList;
import game.Table;
import utils.Pair;

public abstract class Piece {

	private int i;
	private int j;
	protected int type;
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
		
	public Piece(int i2,int j2,int c){
		i=i2;
		j=j2;
		couleur=c;
	}
	public void affichePoss(game.Table T) {
		ArrayList<Pair> d=new ArrayList<Pair>();
		d=this.possibles(T);
		for(byte i=0;i<d.size();i++)
		System.out.println(d.get(i).i+"  "+d.get(i).j);
	}
	public void affiche(){
		if(this.getCouleur()==1)
		System.out.print("noir "+i+" , "+j+"\n");
		else System.out.print("blanc "+i+" , "+j+"\n");
	}
	public Piece(){
		i=0;j=0;
	}
	
	public void move(Table T,Pair p){
		ArrayList<Pair> liste= this.possibles(T);
		if (liste.contains(p)){
			T.supprimer(p.i,p.j);
			i=p.i;
			j=p.j;
		}
		else System.out.println("Deplacement impossible!");
	}
	
	public static int COULEUR_NOIRE=1;
	public static int COULEUR_BLANCHE=0;
	public static int ROI=0;
	public static int DAME=1;
	public static int FOU=2;
	public static int CAVALIER=3;
	public static int TOUR=4;
	public static int PION=5;
	
	public int getType(){
		return type;
	}
}
