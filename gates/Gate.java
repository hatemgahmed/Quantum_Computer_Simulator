package gates;

import Algebra.Matrix;
/**
 * <code>Gate</code> is an abstract class which helps in implementing the Gates and the Gates collections (Since the gate collection classes are in a different package than the gates they are collecting) in Java. 
 * <br /><br />
 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public abstract class Gate {
	/**
	 * The matrix representing the gate, for number of qubits it should be applied on (n), the size of the matrix should be (2^n x 2^n).
	 */
	protected Matrix matrix;
	
	protected int rows;
	
	protected int cols;
}
