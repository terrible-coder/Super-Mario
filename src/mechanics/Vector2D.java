package mechanics;

/**
 * This class is helpful to deal with vectors in 2-Dimensions.
 * It is limited by the accuracy of the primitive double values.
 * A vector is usually represented as a bold font to distinguish from
 * normal variables.
 * A vector A can be written as <b>A</b>
 */
public class Vector2D {

	/**
	 * Horizontal or x component
	 */
	public double x;
	/**
	 * Vertical or y component
	 */
	public double y;
	
	/**
	 * Default constructor. Assigns default initial values to x and y
	 */
	public Vector2D() {
		this(0, 0);
	}
	
	/**
	 * Constructor for class Vector2D. Takes in the x and y components
	 * to initialize this Vector2D instance. Since they are just physical
	 * vectors they all start from the origin and end at point (x, y) in
	 * the 2-D plane.
	 * @param x	The x component of this vector
	 * @param y	The y component of this vector
	 */
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Performs vector addition on this {@link Vector2D} and the specified vector.
	 * This method adds the given vector to this
	 * @param B	The {@link Vector2D} to add to this
	 */
	public void add(Vector2D B) {
		this.x += B.x;
		this.y += B.y;
	}
	
	/**
	 * Performs vector subtraction on this {@link Vector2D} and the specified vector.
	 * This method subtracts the given vector to this
	 * @param B	The {@link Vector2D} to subtract from this
	 */
	public void sub(Vector2D B) {
		this.x -= B.x;
		this.y -= B.y;
	}
	
	/**
	 * Scales this {@link Vector2D} by a real valued factor
	 * @param m	The scaling factor
	 */
	public void mult(double m) {
		this.x *= m;
		this.y *= m;
	}
	
	/**
	 * Rotates this {@link Vector2D} by some angle theta.
	 * The rotation matrix is multiplied to this Vector2D's matrix.
	 * The accuracy decreases at theta values around
	 * odd multiples of {@link Math.PI}/2
	 * @param theta
	 */
	public void rotate(double theta) {
		double x = this.x, y = this.y;
		this.x = x * Math.cos(theta) - y * Math.sin(theta);
		this.y = x * Math.sin(theta) + y * Math.cos(theta);
	}
	
	/**
	 * Reduces this {@link Vector2D} to its unit vector.
	 */
	public void normalise() {
		mult(1/mag());
	}
	
	/**
	 * Calculates the square of this Vector2D's magnitude
	 * @return	Square of magnitude
	 */
	public double magSq() {
		return Math.pow(this.x, 2) + Math.pow(this.y, 2);
	}
	
	/**
	 * @return	Magnitude of this Vector2D
	 */
	public double mag() {
		return Math.sqrt(magSq());
	}
	
	/**
	 * @return	The heading value of this Vector2D
	 */
	public double theta() {
		return Math.atan2(this.y, this.x);
	}
	
	/**
	 * @return	A duplicate copy of this
	 */
	public Vector2D copy() {
		return new Vector2D(this.x, this.y);
	}
	
	/**
	 * Performs vector addition on 2 vectors
	 * @param A	The 1st vector
	 * @param B	The 2nd vector
	 * @return	the vector sum <b>A</b> + <b>B</b>
	 */
	public static Vector2D add(Vector2D A, Vector2D B) {
		return new Vector2D(A.x + B.x, A.y + B.y);
	}
	
	/**
	 * Performs vector subtraction on 2 vectors
	 * @param A	The vector to subtract from
	 * @param B	The vector to subtract
	 * @return	The vector difference <b>A</b> - <b>B</b>
	 */
	public static Vector2D sub(Vector2D A, Vector2D B) {
		return new Vector2D(A.x - B.x, A.y - B.y);
	}
	
	public static Vector2D mult(Vector2D A, double m) {
		return new Vector2D(A.x * m, A.y * m);
	}
	
	/**
	 * Performs scalar multiplication of vectors <b>A</b> and <b>B</b>.
	 * Scalar multiplication of vectors is commutative.
	 * The value of sub(A, B) is the same as that of sub(B, A)
	 * @param A The first vector
	 * @param B	The second vector
	 * @return	The value of the dot product <b>A.B</b>
	 */
	public static double dot(Vector2D A, Vector2D B) {
		return A.x * B.x + A.y * B.y;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)	return true;
		if(o instanceof Vector2D) {
			Vector2D v = (Vector2D)o;
			return this.x == v.x && this.y == v.y;
		}
		return false;
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void set(Vector2D a) {
		set(a.x, a.y);
	}
}
