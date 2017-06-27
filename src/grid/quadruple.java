package grid;

public class quadruple<X, Y, P, C> { //x - x coord, y - y coord, p - ticket price, c - ticket count

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		return result;
	}

	// just for testing
	@Override
	public String toString() {
		return "Pair [x = " + x + ", y = " + y + ", p = " + p + ", c = " + c + "]";
	}

	private X x; 
	private Y y; 
	private P p;
	private C c;
	// constructor

	public quadruple(X x, Y y, P p, C c) {
		this.x = x;
		this.y = y;
		this.p = p;
		this.c = c;
	}

	// get methods
	public X getX() {
		return x;
	}

	public Y getY() {
		return y;
	}
	
	public P getP() {
		return p;
	}
	
	public C getC() {
		return c;
	}

	// set methods
	public void setX(X x) {
		this.x = x;
	}

	public void setY(Y y) {
		this.y = y;
	}
	
	public void setP(P p) {
		this.p = p;
	}
	
	public void setC(C c) {
		this.c = c;
	}
}
