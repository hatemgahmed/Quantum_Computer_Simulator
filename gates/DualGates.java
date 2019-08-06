package gates;

import Algebra.Matrix;
import Quantum.MultiQubit;
import exceptions.GroupedQubitException;
import exceptions.QubitGroupGateSizeMismatchException;
import gates.SingleGates.unaryGate;
import gates.dual.ControlledSingle_Gate;
import gates.dual.RootSwap_Gate;
import gates.dual.Swap_Gate;
import gates.dual.XX_Coupling_Gate;
import gates.dual.YY_Coupling_Gate;
import gates.dual.ZZ_Coupling_Gate;
import gates.single.I_Gate;
/**
 * <code>DualGates</code> is a collection class collects the Dual quantum gates. 
 * It applies the Dual gates on qubits.
 * The dual gates are: swap,rootSwap,Coupling(XX,YY,ZZ),and controlled single Gates(H,S,T,X,Y,Z,I,RootNot).
 * <br /><br />
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class DualGates {
	public enum dualGate{
		Swap,RootSwap;
	}
	public enum Coupling{
		XX,YY,ZZ;
	}
	private static final Swap_Gate swap=new Swap_Gate();
	private static final RootSwap_Gate rootSwap=new RootSwap_Gate();
	private static final I_Gate iGate=new I_Gate();
	
	/**
	* Applies the selected Dual gate on a double qubit represented as <code>MultiQubit</code>.
	* @param gate the selected gate to be applied
	* @param q the double qubit for the gate to be applied on
	*/
	public static void apply(dualGate gate,MultiQubit q) {
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=2)
			throw new QubitGroupGateSizeMismatchException();
		
		switch(gate) {
		case Swap:q.setMatrix(Matrix.multiply(swap.matrix, q.getMatrix()));break;
		case RootSwap:q.setMatrix(Matrix.multiply(rootSwap.matrix, q.getMatrix()));break;
		}
		
	}
	/**
	* Applies the selected controlled unary gate on a double qubit represented as <code>MultiQubit</code>.
	* @param gate the selected gate to be applied
	* @param q the double qubit for the gate to be applied on
	*/
	public static void applyControlled(unaryGate gate,MultiQubit q) {
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=2)
			throw new QubitGroupGateSizeMismatchException();
		q.setMatrix(Matrix.multiply( ( new ControlledSingle_Gate(gate) ).matrix, q.getMatrix()));
	}
	/**
	* Applies the selected coupling Dual gate on a double qubit represented as <code>MultiQubit</code>.
	* @param gate the selected gate to be applied
	* @param q the double qubit for the gate to be applied on
	*/
	public static void applyCoupling(Coupling c, double angle, MultiQubit q) {
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=2)
			throw new QubitGroupGateSizeMismatchException();
		switch(c) {
		case XX:q.setMatrix(Matrix.multiply( ( new XX_Coupling_Gate(angle) ).matrix, q.getMatrix()));break;
		case YY:q.setMatrix(Matrix.multiply( ( new YY_Coupling_Gate(angle) ).matrix, q.getMatrix()));break;
		case ZZ:q.setMatrix(Matrix.multiply( ( new ZZ_Coupling_Gate(angle) ).matrix, q.getMatrix()));break;
		}
	}
	/**
	* Applies the selected Dual gate on the last 2 qubits from the left of a tripple represented as <code>MultiQubit</code>.
	* @param gate the selected gate to be applied
	* @param q the double qubit for the gate to be applied on
	*/
	public static void applyOnTripple(dualGate gate,MultiQubit q) {
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=3)
			throw new QubitGroupGateSizeMismatchException();
		
		switch(gate) {
		case Swap:q.setMatrix(Matrix.multiply( Matrix.TensorProduct(iGate.matrix, swap.matrix) , q.getMatrix()));break;
		case RootSwap:q.setMatrix(Matrix.multiply(Matrix.TensorProduct(iGate.matrix, rootSwap.matrix), q.getMatrix()));break;
		}
			
	}
	/**
	* Applies the selected controlled unary gate on the last 2 qubits from the left of a tripple represented as <code>MultiQubit</code>.
	* @param gate the selected gate to be applied
	* @param q the double qubit for the gate to be applied on
	*/
	public static void applyControlledOnTripple(unaryGate gate,MultiQubit q) {
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=3)
			throw new QubitGroupGateSizeMismatchException();
		q.setMatrix(Matrix.multiply( Matrix.TensorProduct(iGate.matrix,( new ControlledSingle_Gate(gate) ).matrix), q.getMatrix()));
	}
	/**
	* Applies the selected Dual gate on the last 2 qubits from the left of a tripple represented as <code>MultiQubit</code>.
	* @param gate the selected gate to be applied
	* @param q the double qubit for the gate to be applied on
	*/
	public static void applyCouplingOnTriple(Coupling c, double angle, MultiQubit q) {
		if(q.isGrouped())
			throw new GroupedQubitException();
		if(q.getNQubits()!=3)
			throw new QubitGroupGateSizeMismatchException();
		switch(c) {
		case XX:q.setMatrix(Matrix.multiply( Matrix.TensorProduct(iGate.matrix, ( new XX_Coupling_Gate(angle) ).matrix ), q.getMatrix()));break;
		case YY:q.setMatrix(Matrix.multiply( Matrix.TensorProduct(iGate.matrix, ( new YY_Coupling_Gate(angle) ).matrix), q.getMatrix()));break;
		case ZZ:q.setMatrix(Matrix.multiply( Matrix.TensorProduct(iGate.matrix, ( new ZZ_Coupling_Gate(angle) ).matrix), q.getMatrix()));break;
		}
	}

	
}
