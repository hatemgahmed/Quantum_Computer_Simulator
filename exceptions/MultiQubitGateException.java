package exceptions;
/**
 * This Exception is thrown when a gate is requested to be applied on qubits, but the number of qubits does not equal the number of qubits the gate accepts.
 * 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
@SuppressWarnings("serial")
public class MultiQubitGateException extends ArrayIndexOutOfBoundsException{
	
	public MultiQubitGateException() {
		super("The number of gates does not equal the number of qubits");
	}
	
}
