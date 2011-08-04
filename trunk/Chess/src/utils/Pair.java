package utils;

public class Pair {
	public int i;
	public int j;
	public Pair(int h,int k){
		i=h;
		j=k;
	};
	private boolean equals(Pair P,int i){
		return ((P.i==this.i)&&(P.j==this.j));
		
	}
@Override
	public boolean equals(Object O){
	
		if (O.getClass()==this.getClass()){
			return equals((Pair)O,0);
		}
		else return false;
		
	}
}
