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
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		
		return true;
	}

	
}
