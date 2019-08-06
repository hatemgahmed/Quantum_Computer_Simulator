package Algebra;
/**
 * <code>Matrix</code> is a class which implements Matrices that contains complex numbers in Java. 
 * It includes basic operations that can be performed on Matrices such as,
 * multiplication, Dot product and Kronecker product.
 * <br /><br />
 * The features of this library include:<br />
 * <ul>
 * <li>Arithmetic Operations (multiplication, Kronecker Product, Dot product)</li>
 * </ul>
 * 
 * @author      Hatem Gamal Ahmed Elsayed
 * @version		1.0
 * 
 */
public class Matrix {
	/**
	* The data of the <code>Matrix</code>.
	*/
	private ComplexNumber matrix[][];
	
	/**
	* Constructs a new <code>Matrix</code> object.
	* @param rows the number of rows of the <code>Matrix</code>
	* @param cols the number of columns of the <code>Matrix</code>
	*/
	public Matrix(int rows, int cols) {
		matrix = new ComplexNumber[rows][cols];
	}
	
	/**
	* Constructs a new <code>Matrix</code> object.
	* @param m the data of the <code>Matrix</code>
	*/
	public Matrix(ComplexNumber[][] m) {
		this.matrix = m;
	}
	/**
	* Gets a row from the <code>Matrix</code>.
	* @param row the desired row to get from the <code>Matrix</code>.
	* @return the desired <code>Matrix</code> row.
	*/
	public ComplexNumber[] getRow(int row) {
		return matrix[row];
	}
	/**
	* Sets a row to the <code>Matrix</code>.
	* @param rowNumber <code>Matrix</code>.
	* @param row the row data <code>Matrix</code>.
	*/
	public void assignRow(int rowNumber, ComplexNumber[] row) {
		matrix[rowNumber] = row;
	}
	//credits to: https://stackoverflow.com/questions/17623876/matrix-multiplication-using-arrays 
	/**
	* Multiplies Two <code>Matrices</code>.
	* @param m1 the first <code>Matrix</code>.
	* @param m2 the second <code>Matrix</code>.
	* @return the resultant <code>Matrix</code>.
	*/
	public static Matrix multiply(Matrix m1, Matrix m2) {
		int m1ColLength = m1.matrix[0].length; // m1 columns length
		int m2RowLength = m2.matrix.length; // m2 rows length
		if (m1ColLength != m2RowLength)
			return null; // matrix multiplication is not possible
		int mRRowLength = m1.matrix.length; // m result rows length
		int mRColLength = m2.matrix[0].length; // m result columns length
		ComplexNumber[][] mResult = new ComplexNumber[mRRowLength][mRColLength];
		for (int i = 0; i < mResult.length; i++)
			for (int j = 0; j < mResult[0].length; j++)
				mResult[i][j] = new ComplexNumber();
		for (int i = 0; i < mRRowLength; i++) { // rows from m1
			for (int j = 0; j < mRColLength; j++) { // columns from m2
				for (int k = 0; k < m1ColLength; k++) { // columns from m1
					mResult[i][j].add(ComplexNumber.multiply(m1.matrix[i][k], m2.matrix[k][j]));
				}
			}
		}
		return new Matrix(mResult);
	}

	@Override
	public String toString() {

		String result = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result += matrix[i][j].toString();
			}
			if(i!=matrix.length-1)
				result += "\n";
		}
		return result;
	}
	/**
	* Gets the magnitude of every ComplexNumber of a 1D <code>Matrix</code>.
	* @return the magnitude of every ComplexNumber of a 1D <code>Matrix</code>.
	*/
	public double[] qubitMagnitude() {
		double[] mag = new double[matrix.length];
		for (int i = 0; i < matrix.length; i++)
			mag[i] = matrix[i][0].mod();
		return mag;
	}
	/**
	* Gets the Kronecker product of Two <code>Matrices</code>.
	* @param m1 the first <code>Matrix</code>.
	* @param m2 the second <code>Matrix</code>.
	* @return the resultant <code>Matrix</code>.
	*/
	public static Matrix TensorProduct(Matrix a, Matrix b) {
		ComplexNumber[][] A = a.matrix;
		ComplexNumber[][] B = b.matrix;
		int rowA = A.length;
		int rowb = B.length;
		int colA = A[0].length;
		int colB = B[0].length;
		ComplexNumber[][] C = new ComplexNumber[rowA * rowb][colA * colB];

		//loops on rows(A)
		for (int i = 0; i < rowA; i++) {

			//loops on cols(A)
			for (int j = 0; j < colA; j++) {

				//loops on row(B)
				for (int k = 0; k < rowb; k++) {

					//loops on col(B)
					for (int l = 0; l < colB; l++) {

						// Each element of matrix A is multiplied by whole Matrix B
						// and then stored in the corrected place in Matrix C
						
						C[i*rowb + k][j*colB + l] = ComplexNumber.multiply(A[i][j], B[k][l]);
						
					}
				}
			}
		}
		Matrix out=new Matrix(C);
		return out;
	}
	/**
	* Gets the Dot product of a <code>Matrix</code>.
	* @param mult the multiplicant <code>ComplexNumber</code>.
	* @param mat the <code>Matrix</code> to be multiplied by.
	* @return the resultant <code>Matrix</code>.
	*/
	public static Matrix dotProduct(ComplexNumber mult,Matrix mat){
		
		ComplexNumber[][] output=new ComplexNumber[mat.matrix.length][mat.matrix[0].length];
		for(int i=0;i<mat.matrix.length;i++)
			for(int j=0;j<mat.matrix[i].length;j++)
				output[i][j]=ComplexNumber.multiply(mult, mat.matrix[i][j]);
		return new Matrix(output);
		
	}


}
