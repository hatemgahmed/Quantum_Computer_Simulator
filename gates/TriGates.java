package gates;

import Algebra.Matrix;
import Quantum.MultiQubit;
import exceptions.GroupedQubitException;
import exceptions.QubitGroupGateSizeMismatchException;
import gates.tri.CSHL_Gate;
import gates.tri.CSHR_Gate;
import gates.tri.CSWAP_Gate;
import gates.tri.Controlled_CNOT_Gate;
/**
 * <code>TriGates</code> is a collection class collects the tri quantum gates. 
 * It applies the tri gates on qubits.
 * The tri gates are: Controlled_CNOT,Controlled_Swap,Circular_Shift_Right and Circular_Shift_Left gate.
 * <br /><br />
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class TriGates {
	public enum triGate{
		Controlled_CNOT,Controlled_Swap,Circular_Shift_Right,Circular_Shift_Left;
	}
	public static final Controlled_CNOT_Gate ccnot=new Controlled_CNOT_Gate();
	public static final CSWAP_Gate cswap=new CSWAP_Gate();
	public static final CSHL_Gate cshl=new CSHL_Gate();
	public static final CSHR_Gate cshr=new CSHR_Gate();
	
	/**
	* Applies the selected unary gate on a single <code>qubit</code>.
	* @param gate the selected gate to be applied
	* @param q the tripple qubit for the gate to be applied on
	*/
	public static void apply(triGate gate,MultiQubit q) {
		
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=3)
			throw new QubitGroupGateSizeMismatchException();
		q.setMatrix(Matrix.multiply(enumToMatrix(gate), q.getMatrix()));
		
	}
	
	public static Matrix enumToMatrix(triGate gate) {
		switch(gate) {
		case Circular_Shift_Left:return cshl.matrix;
		case Circular_Shift_Right:return cshr.matrix;
		case Controlled_CNOT:return ccnot.matrix;
		case Controlled_Swap:return cswap.matrix;
		}
		return null;
	}
}
