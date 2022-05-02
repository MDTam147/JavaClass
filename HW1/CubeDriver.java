import java.util.Scanner;

/**
 * 
 * @author Tam Doan
 * This is HW1, problem 2.3 (test for 2.2)
 * This class is responsible for instantiating the Cube object in 2.2
 * and calling the methods of it.
 *
 */
public class CubeDriver {

	public static void main(String[] args) {
		
		// prompting user for side length
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter cube's side length: ");
		double sideLength = scanner.nextDouble();
		
		Cube cube = new Cube(sideLength);
		
		System.out.printf("Surface area: %.2f\n",cube.surfaceArea());
		System.out.printf("Volume: %.2f",cube.volume());

	} //end of main

} //end of CubeDriver
