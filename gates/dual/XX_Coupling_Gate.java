package gates.dual;

import Algebra.ComplexNumber;
import Algebra.Matrix;
import gates.Gate;
/**
 * <code>XX_Coupling_Gate</code> is a class which implements the XX Coupling gate in Java. 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class XX_Coupling_Gate extends Gate{
	/**
	 * Constructs a Gate with Matrix:
	 *             [1 0 0 e^i(angle-pi/2)]
	 *             [0 1 -i 0] 
	 *1/sqrt(2) *  [0 -i 1 0]
	 *             [e^i(angle-pi/2) 0 0 1]
	 */
	public XX_Coupling_Gate(double angle) {
		ComplexNumber[][] mat=new ComplexNumber[4][];
		ComplexNumber[] row0={new ComplexNumber(1, 0),new ComplexNumber(0, 0),new ComplexNumber(0, 0),ComplexNumber.euler(1, -Math.PI/2 +angle)};
		ComplexNumber[] row1= {new ComplexNumber(0, 0),new ComplexNumber(1, 0),new ComplexNumber(0, -1),new ComplexNumber(0, 0)};
		ComplexNumber[] row2= {new ComplexNumber(0, 0),new ComplexNumber(0, -1),new ComplexNumber(1, 0),new ComplexNumber(0, 0)};
		ComplexNumber[] row3= {ComplexNumber.euler(1, -Math.PI/2 -angle),new ComplexNumber(0, 0),new ComplexNumber(0, 0),new ComplexNumber(1, 0)};
		rows=cols=4;
		matrix=new Matrix(rows, cols);
		mat[0]=row0;
		mat[1]=row1;
		mat[2]=row2;
		mat[3]=row3;
		divideSqrt2(mat);
		matrix.assignRow(0,mat[0]);
		matrix.assignRow(1,mat[1]);
		matrix.assignRow(2,mat[2]);
		matrix.assignRow(3,mat[3]);
	}
	private static void divideSqrt2(ComplexNumber[][] m) {
		ComplexNumber sqrt2=new ComplexNumber(Math.sqrt(2),0);
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				m[i][j].divide(sqrt2);
	}
}
