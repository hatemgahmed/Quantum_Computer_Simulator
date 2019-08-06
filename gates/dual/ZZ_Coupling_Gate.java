package gates.dual;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>ZZ_Coupling_Gate</code> is a class which implements the ZZ Coupling gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class ZZ_Coupling_Gate extends Gate{
	
	/**
	 * Constructs a Gate with Matrix:
	 * [e^i(angle/2) 0 0 0]
	 * [0 e^i(-angle/2) 0 0]
	 * [0 0 e^i(-angle/2) 0] 
	 * [0 0 0 e^i(angle/2)]
	 */
	public ZZ_Coupling_Gate(double angle) {
		final ComplexNumber[] row0= {ComplexNumber.euler(1, angle/2),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
		final ComplexNumber[] row1= {new ComplexNumber(0, 0),ComplexNumber.euler(1, -angle/2),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
		final ComplexNumber[] row2= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),ComplexNumber.euler(1, -angle/2),new ComplexNumber(0, 0)};
		final ComplexNumber[] row3= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),ComplexNumber.euler(1, angle/2)};
		rows=cols=4;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
		matrix.assignRow(2,row2);
		matrix.assignRow(3,row3);
	}
}
