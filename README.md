# QC
A simulator for Quantum Computer

It uses Matrices to simulate the behaviour of quantum computer qubits.

n qubits are represented by a (2^n)x1 matrix, each element represents the square root of the probability of collapsing the qubit to the corresponding state.

A gate that takes n inputs is represented as a (2^n)x(2^n) matrix.

Applying a gate (g) on some qubits (q) is done by multiplying the matrices that represent them together: g.q

There are two hypothetical gates that I innovated to help ease implementing this simulator, for more information about them and how the simuulator works, 
please read the Report.pdf file
