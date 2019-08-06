package gates.dual;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
import gates.SingleGates;
/**
 * <code>ControlledSingle_Gate</code> is a class which implements the Controlled gates in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class ControlledSingle_Gate extends Gate{
	private static final ComplexNumber[] row0= {new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row1= {new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row2= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	private static final ComplexNumber[] row3= {new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0)};
	
	/**
	 * Constructs a Gate with Matrix:
	 * [1 0 0 0]
	 * [0 1 0 0]
	 * [0 0 a b] 
	 * [0 0 c d]
	 * where a,b,c,d are the data values of the single gate matrix.
	 * @param unaryGate the single gate to be controlled.
	 */
	public ControlledSingle_Gate(SingleGates.unaryGate unaryGate) {
		rows=cols=4;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
		Matrix a=SingleGates.enumToMatrix(unaryGate);
		row2[2]=a.getRow(0)[0];
		row2[3]=a.getRow(0)[1];
		matrix.assignRow(2,row2);
		row3[2]=a.getRow(1)[0];
		row3[3]=a.getRow(1)[1];
		matrix.assignRow(3,row3);
	}
}
