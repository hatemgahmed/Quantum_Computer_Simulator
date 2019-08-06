package exceptions;
/**
 * This Exception is thrown when a gate is requested to be applied on a qubit which is grouped in a larger qubit cluster.
 * 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
@SuppressWarnings("serial")
public class GroupedQubitException extends ArrayIndexOutOfBoundsException{
	
	public GroupedQubitException() {
		super("One or more Qubits to be applied is grouped in a MultiQubit");
	}
	
}
