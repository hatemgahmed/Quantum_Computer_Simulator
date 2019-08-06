package gates.single;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>Z_Gate</code> is a class which implements the Z gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class Z_Gate extends Gate{
	
	private static final ComplexNumber[] row0= {new ComplexNumber(1, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row1= {new ComplexNumber(0, 0),new ComplexNumber(-1, 0)};
	
	/**
	 * Constructs a Gate with Matrix:
	 * [1 0]
	 * [0 -1] 
	 */
	public Z_Gate() {
		rows=cols=2;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
	}
	
	
}