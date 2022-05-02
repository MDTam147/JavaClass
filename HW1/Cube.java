
/**
 * 
 * @author Tam Doan
 * This is HW1, problem 2.2.
 * This is the class file for the Cube object.
 *
 */

public class Cube {
	private double sideLength;
	
	public Cube(double sideLength){
		this.sideLength = sideLength;
		
	} //end of constructor
	
	public double surfaceArea() {
		return 6*sideLength*sideLength;
	} // end of surfaceArea()
	
	public double volume() {
		return sideLength*sideLength*sideLength;
	} // end of volume()

} // end of Cube()
