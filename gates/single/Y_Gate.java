package gates.single;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>Y_Gate</code> is a class which implements the Y gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class Y_Gate extends Gate{
	
	private static final ComplexNumber[] row0= {new ComplexNumber(0, 0),new ComplexNumber(0, -1)};
	private static final ComplexNumber[] row1= {new ComplexNumber(0, 1),new ComplexNumber(0, 0)};
	
	/**
	 * Constructs a Gate with Matrix:
	 * [0 -i]
	 * [i 0] 
	 */
	public Y_Gate() {
		rows=cols=2;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
	}
	
	
}