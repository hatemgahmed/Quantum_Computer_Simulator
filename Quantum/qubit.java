package Quantum;

import Algebra.ComplexNumber;
import Algebra.Matrix;
/**
 * <code>qubit</code> is a class which simulates single qubits using matrices in Java.
 * <br /><br />
 * 
 * @author      Hatem Gamal Ahmed
 * @version		1.0
 * 
 */
public class qubit extends MultiQubit{
	/**
	 * A created qubit is always 0, you can apply an X gate on it to set it to 1.
	 */
	static final ComplexNumber[][] mat= {{new ComplexNumber(1, 0)},{new ComplexNumber(0, 0)}};
	/**
	 * Constructs a Qubit with possibility 100% of being 0.
	 */
	public qubit() {
		super(mat,1);
		this.qubits.add(this);
	}
}