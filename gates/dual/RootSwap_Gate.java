package gates.dual;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>RootSwap_Gate</code> is a class which implements the RootSwap gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class RootSwap_Gate extends Gate{
	private static final ComplexNumber[] row0= {new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row1= {new ComplexNumber(0, 0),new ComplexNumber(0.5, 0.5),new ComplexNumber(0.5, -0.5),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row2= {new ComplexNumber(0, 0),new ComplexNumber(0.5, -0.5),new ComplexNumber(0.5, 0.5),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row3= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0)};
	
	/**
	 * Constructs a Gate with Matrix:
	 * [1 0 0 0]
	 * [0 (0.5+0.5i) (0.5-0.5i) 0] 
	 * [0 (0.5-0.5i) (0.5+0.5i) 0]
	 * [0 0 0 1]
	 */
	public RootSwap_Gate() {
		rows=cols=4;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
		matrix.assignRow(2,row2);
		matrix.assignRow(3,row3);
	}
}
