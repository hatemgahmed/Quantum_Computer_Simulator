package Quantum;


import java.util.ArrayList;

import Algebra.ComplexNumber;
import Algebra.Matrix;
/**
 * <code>MultiQubit</code> is a class which represents a cluster of qubits in java. 
 * It is represented in the form of Knocker product of the sequence of individual qubits.
 * <br /><br />
 * The features of this library include:<br />
 * <ul>
 * <li>Merging qubits together</li>
 * <li>Measuring the qubits based on the function Math.random()</li>
 * </ul>
 * 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class MultiQubit {
	Matrix m;
	int nQubits;
	boolean insideAnotherGroup=false;
	/**
	* The original single qubit references that constructs the <code>MultiQubit</code> cluster.
	*/
	public ArrayList<qubit> qubits=new ArrayList<qubit>();
	
	void grouped() {
		insideAnotherGroup=true;
	}
	/**
	 * 
	 * @return boolean that is true if the qubit is inside a qubit cluster.
	 */
	public boolean isGrouped() {
		return insideAnotherGroup;
	}
	/**
	 * Constructs a MultiQubit with a matrix and the number of qubits, m should have a sive of (2^n x 1).
	 * @param m The matrix.
	 * @param n the number of qubits.
	 */
	public MultiQubit(Matrix m,int n) {
		this.m=m;
		this.nQubits=n;
	}
	/**
	 * Constructs a MultiQubit with a matrix and the number of qubits, m should have a sive of (2^n x 1).
	 * @param m 2D array containing the matrix data.
	 * @param n the number of qubits.
	 */
	public MultiQubit(ComplexNumber[][] m ,int n) {
		this.m=new Matrix(m);
		this.nQubits=n;
	}
	
	public void setMatrix(Matrix m) {
		this.m=m;
	}
	
	public Matrix getMatrix() {
		return m;
	}
	/**
	* Outputs the number of single qubits the <code>MultiQubit</code> cluster represents.
	*/
	public int getNQubits() {
		return nQubits;
	}
	/**
	* Outputs an int[] array of the Collapsed state of the <code>MultiQubit</code> cluster to a single configuration.
	*/
	public int[] measure() {
		double[] p=m.qubitMagnitude();
		double rand=Math.random();
		int number=0;
		
		
		double[] arrSum=getSumArr(p);
		for(int i=1;i<arrSum.length;i++)
			if(rand>arrSum[i])
				number++;

		
		int[] out=new int[nQubits];
		String numberString=Integer.toBinaryString(number);
		while(numberString.length()<out.length)
			numberString="0"+numberString;
		
		char[] narr=numberString.toCharArray();
		
		for(int i=narr.length-1;i>=0;i--)
			out[i]=Integer.parseInt(narr[i]+"");
		
		return out;
	}
	/**
	 * 
	 * @return an array that represents the probability of each value of the grouped qubits.
	 */
	public double[] getProbability() {
		return m.qubitMagnitude();
	}
	
	@Override
	public String toString() {
		return m.toString()+"/n"+"Number of Qubits: "+nQubits;
		
	}
	
	/**
	 * gets an array of sum that has size = inputArray.size+1, with first value in the array=0.
	 * @param input the array
	 * @return the array of sum
	 */
	private static double[] getSumArr(double[] input) {
		double sum[] =new double[input.length+1];
		for(int i=1;i<sum.length;i++)
			sum[i]=sum[i-1]+input[i-1];
		return sum;
	}
	/**
	* Appends the input bits to the right.
	* @param a the MultiQubit group to be appended
	*/
	public MultiQubit append(MultiQubit a) {
		a.grouped();
		MultiQubit q=TensorProduct(this, a);
		q.qubits.addAll(a.qubits);
		return q;
		
	}
	
	private static MultiQubit TensorProduct(MultiQubit a,MultiQubit b){
		return new MultiQubit(Matrix.TensorProduct(a.m, b.m),a.nQubits+b.nQubits);
	}
	/**
	* Constructs a new <code>MultiQubit</code> object that represents the concatanation of the two input <code>MultiQubit</code> objects.
	* @param a the first <code>MultiQubit</code> object to be put on the left
	* @param b the second <code>MultiQubit</code> object to be put on the right
	*/
	public static MultiQubit appendMultipleQubits(MultiQubit[] qs) {
		MultiQubit q=qs[0];
		for(int i=1;i<qs.length;i++)
			q=q.append(qs[i]);
		return q;
	}
	
}
