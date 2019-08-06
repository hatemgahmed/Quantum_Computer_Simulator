package gates.dual;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>YY_Coupling_Gate</code> is a class which implements the YY Coupling gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class YY_Coupling_Gate extends Gate{
	/**
	 * Constructs a Gate with Matrix:
	 * [cos(angle) 0 0 isin(angle)]
	 * [0 cos(angle) -isin(angle) 0]
	 * [0 -isin(angle) cos(angle) 0] 
	 * [isin(angle) 0 0 cos(angle)]
	 */
	public YY_Coupling_Gate(double angle) {
		ComplexNumber[] row0={new ComplexNumber(Math.cos(angle), 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(0, Math.sin(angle))};
		ComplexNumber[] row1= {new ComplexNumber(0, 0),new ComplexNumber(Math.cos(angle), 0),new ComplexNumber(0, -Math.sin(angle)),new ComplexNumber(0, 0)};
		ComplexNumber[] row2= {new ComplexNumber(0, 0),new ComplexNumber(0, -Math.sin(angle)),new ComplexNumber(Math.cos(angle), 0),new ComplexNumber(0, 0)};
		ComplexNumber[] row3= {new ComplexNumber(0, Math.sin(angle)),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(Math.cos(angle), 0)};
		rows=cols=4;
		matrix=new Matrix(rows, cols);
		matrix.assignRow(0,row0);
		matrix.assignRow(1,row1);
		matrix.assignRow(2,row2);
		matrix.assignRow(3,row3);
	}
}
