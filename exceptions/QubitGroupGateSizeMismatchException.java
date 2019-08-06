package exceptions;
/**
 * This Exception is thrown when a gate is requested to be applied on qubits, but the number of qubits does not equal the number of qubits the gate accepts.
 * 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
@SuppressWarnings("serial")
public class QubitGroupGateSizeMismatchException extends ArrayIndexOutOfBoundsException{

	public QubitGroupGateSizeMismatchException() {
		super("Qubit group size doesn't match the number of applied gate input");
	}
	
}
