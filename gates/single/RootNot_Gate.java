package gates.single;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>RootNot_Gate</code> is a class which implements the RootNot gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class RootNot_Gate extends Gate{
	private static final ComplexNumber[] row0= {new ComplexNumber(0.5, 0.5),new ComplexNumber(0.5, -0.5)};
	private static final ComplexNumber[] row1= {new ComplexNumber(0.5, -0.5),new ComplexNumber(0.5, 0.5)};
	
	/**
	 * Constructs a Gate with Matrix:
	 * [(0.5+0.5i) (0.5-0.5i)]
	 * [(0.5-0.5i) (0.5+0.5i)] 
	 */
	public RootNot_Gate() {
		rows=cols=2;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
	}
	
}
