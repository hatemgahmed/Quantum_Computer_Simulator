package gates;

import Algebra.Matrix;
import Quantum.MultiQubit;
import Quantum.qubit;
import exceptions.GroupedQubitException;
import exceptions.MultiQubitGateException;
import gates.single.H_Gate;
import gates.single.I_Gate;
import gates.single.RootNot_Gate;
import gates.single.S_Gate;
import gates.single.T_Gate;
import gates.single.X_Gate;
import gates.single.Y_Gate;
import gates.single.Z_Gate;

/**
 * <code>SingleGates</code> is a collection class collects the single quantum gates. 
 * It applies the single gates on qubits.
 * The single gates are: H,S,T,X,T,Z,RootNot and I gate.
 * <br /><br />
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class SingleGates {
	public enum unaryGate{
		H,S,T,X,Y,Z,I,RootNot;
	}
	private static final H_Gate h = new H_Gate();
	private static final S_Gate s = new S_Gate();
	private static final T_Gate t = new T_Gate();
	private static final X_Gate x = new X_Gate();
	private static final Y_Gate y = new Y_Gate();
	private static final Z_Gate z = new Z_Gate();
	private static final I_Gate I = new I_Gate();
	private static final RootNot_Gate rn = new RootNot_Gate();
	
	/**
	* Applies the selected unary gate on a single <code>qubit</code>.
	* @param gate the selected gate to be applied
	* @param q the single qubit for the gate to be applied on
	*/
	public static void apply(unaryGate gate,qubit q) {
		
		if(q.isGrouped())
			throw new GroupedQubitException();
		
		q.setMatrix(Matrix.multiply(enumToMatrix(gate), q.getMatrix()));
		
	}
	
	/**
	* Applies a sequence of unary gates on an equally lengthy sequence of single qubits represented as <code>MultiQubit</code>.
	* @param gates the sequence of unary gates to be applied
	* @param q the MultiQubit sequence for the gate[i] to be applied on qubit[i]
	*/
	public static void apply(unaryGate[] gates, MultiQubit q) {
		
		if(q.isGrouped())
			throw new GroupedQubitException();
		
		if(gates.length!=q.getNQubits())
			throw new MultiQubitGateException();
		
		if(q.getNQubits()==1) {
			apply(gates[0],(qubit)q);
			return;
		}
		
		Matrix gate=enumToMatrix(gates[0]);
		
		for(int i=1;i<gates.length;i++)
			gate=Matrix.TensorProduct(gate, enumToMatrix(gates[i]));
		
		q.setMatrix(Matrix.multiply( gate , q.getMatrix()));
	}
	
	
	
	public static Matrix enumToMatrix(unaryGate gate) {
		switch(gate) {
		case H: return h.matrix; 
		case S: return s.matrix;
		case T: return t.matrix;
		case X: return x.matrix;
		case Y: return y.matrix;
		case Z: return z.matrix;
		case I:return I.matrix;
		case RootNot: return rn.matrix;
		}
		return null;
	}
}
