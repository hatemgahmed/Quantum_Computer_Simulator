package gates.single;

import Algebra.*;
import gates.Gate;

/**
 * <code>H_Gate</code> is a class which implements the H gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class H_Gate extends Gate{
	
	private static final ComplexNumber[] row0= {new ComplexNumber(1/Math.sqrt(2), 0),new ComplexNumber(1/Math.sqrt(2), 0)};
	private static final ComplexNumber[] row1= {new ComplexNumber(1/Math.sqrt(2), 0),new ComplexNumber(-1/Math.sqrt(2), 0)};
	
	
	/**
	 * Constructs a Gate with Matrix:
	 * [1/sqrt(2) 1/sqrt(2)]
	 * [1/sqrt(2) -1/sqrt(2)] 
	 */
	public H_Gate() {
		rows=cols=2;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
	}
	
	
}
