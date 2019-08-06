package gates.tri;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>CSHL_Gate</code> is a class which implements a gate that circulates shift left a 3-qubit group in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class CSHL_Gate extends Gate{
	private static final ComplexNumber[] row0= {new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row1= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row2= {new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row3= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row4= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row5= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row6= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row7= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0)};
	
	/**
	 * Constructs a Gate with Matrix:
	 * [1 0 0 0 0 0 0 0]
	 * [0 0 0 0 1 0 0 0] 
	 * [0 1 0 0 0 0 0 0]
	 * [0 0 0 0 0 1 0 0] 
	 * [0 0 1 0 0 0 0 0] 
	 * [0 0 0 0 0 0 1 0]
	 * [0 0 0 1 0 0 0 0] 
	 * [0 0 0 0 0 0 0 1] 
	 */
	public CSHL_Gate() {
		rows=cols=8;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
		matrix.assignRow(2,row2);
		matrix.assignRow(3,row3);
		matrix.assignRow(4,row4);
		matrix.assignRow(5,row5);
		matrix.assignRow(6,row6);
		matrix.assignRow(7,row7);
	}
}
