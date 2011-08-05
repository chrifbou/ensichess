package utils;

import utils.Pair;

public class Pair {
	public int i;
	public int j;
	public Pair(int k,int l){
		i=k;
		j=l;
	};
	private boolean equals(Pair P,int k){
		return ((P.i==this.i)&&(P.j==this.j));
		// a koi ser ce i passe en parametre
	}
@Override
	public boolean equals(Object O){
	
		if (O.getClass()==this.getClass()){
			return equals((Pair)O,0);
		}
		else return false;
		
	}
}
