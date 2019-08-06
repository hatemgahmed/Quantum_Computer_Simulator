package test;

import java.awt.EventQueue;
import java.util.Arrays;

import Quantum.MultiQubit;
import Quantum.qubit;
import gates.DualGates;
import gates.SingleGates;
import gates.SingleGates.unaryGate;
import gates.TriGates;
import gates.TriGates.triGate;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.stage.Stage;


public class Testing 
//extends Application 
{
	
	static int[][] zo=new int[6][2];

    final static String[] names= {"qubit0","qubit1","qubit2","qubit3","qubit4","qubit5"};
	
    static int times=1024;
    
	public static void test() {
		qubit q0=new qubit();
		qubit q1=new qubit();
		qubit q2=new qubit();
		qubit q3=new qubit();
		qubit q4=new qubit();
		qubit q5=new qubit();
		SingleGates.apply(unaryGate.X, q0);
		SingleGates.apply(unaryGate.Y, q1);
		SingleGates.apply(unaryGate.Z, q2);
		SingleGates.apply(unaryGate.H, q3);
		SingleGates.apply(unaryGate.S, q4);
		SingleGates.apply(unaryGate.T, q5);
//		for(int i=0;i<times;i++) {
//			int x0 = q0.measure();
//			int x1 = q1.measure();
//			int x2 = q2.measure();
//			int x3 = q3.measure();
//			int x4 = q4.measure();
//			int x5 = q5.measure();
//			zo[0][x0]++;
//			zo[1][x1]++;
//			zo[2][x2]++;
//			zo[3][x3]++;
//			zo[4][x4]++;
//			zo[5][x5]++;
//		}
	}
	
	static void TensorProduct() {

		qubit q0=new qubit();
		qubit q1=new qubit();
		qubit q2=new qubit();
//		UnaryGates.apply(gate.X, q0);
		MultiQubit mq1=q0.append(q1);
		mq1=mq1.append(q2);
		unaryGate[] gates={unaryGate.X, unaryGate.X,unaryGate.I};
		
		qubit[] qubits= {new qubit(),new qubit(),new qubit()};
		MultiQubit mq2=MultiQubit.appendMultipleQubits(qubits);
		SingleGates.apply( gates , mq2);
		System.out.println(mq2.getNQubits());
		TriGates.apply(triGate.Controlled_Swap, mq2);
		System.out.println(Arrays.toString(mq2.measure()));
		
//		System.out.println(q0.TensorProduct(q1));
		
	}
	
//	 @Override public void start(Stage stage) {
//	        stage.setTitle("Qubits");
//	        final CategoryAxis xAxis = new CategoryAxis();
//	        final NumberAxis yAxis = new NumberAxis();
//	        final BarChart<String,Number> bc = 
//	            new BarChart<String,Number>(xAxis,yAxis);
//	        bc.setTitle("Statistics");
//	        xAxis.setLabel("Qubits");       
//	        yAxis.setLabel("Occurences");
//	 
//	        XYChart.Series series1 = new XYChart.Series();
//	        series1.setName("0's");       
//	        series1.getData().add(new XYChart.Data(names[0], zo[0][0]*100/times));
//	        series1.getData().add(new XYChart.Data(names[1], zo[1][0]*100/times));
//	        series1.getData().add(new XYChart.Data(names[2], zo[2][0]*100/times));
//	        series1.getData().add(new XYChart.Data(names[3], zo[3][0]*100/times));
//	        series1.getData().add(new XYChart.Data(names[4], zo[4][0]*100/times));    
//	        series1.getData().add(new XYChart.Data(names[5], zo[5][0]*100/times));      
//	        
//	        XYChart.Series series2 = new XYChart.Series();
//	        series2.setName("1's");       
//	        series2.getData().add(new XYChart.Data(names[0], zo[0][1]*100/times));
//	        series2.getData().add(new XYChart.Data(names[1], zo[1][1]*100/times));
//	        series2.getData().add(new XYChart.Data(names[2], zo[2][1]*100/times));
//	        series2.getData().add(new XYChart.Data(names[3], zo[3][1]*100/times));
//	        series2.getData().add(new XYChart.Data(names[4], zo[4][1]*100/times)); 
//	        series2.getData().add(new XYChart.Data(names[5], zo[5][1]*100/times)); 
//	        
//	        Scene scene  = new Scene(bc,800,600);
//	        bc.getData().addAll(series1, series2);
//	        stage.setScene(scene);
//	        stage.show();
//	    }
	 
	    public static void main(String[] args) {
//	    	TensorProduct();
	    	test();
//	        launch(args);
	    }
}
