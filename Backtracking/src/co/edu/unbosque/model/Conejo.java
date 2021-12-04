/**
 * El package que contiene la clase
 */
package co.edu.unbosque.model;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




/**
 * Clase Nutricionista que contiene los metodos que permite realizar el backtraking del problema del nutricionista
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class Conejo {

	private int filas; // columnas
	private int col; // filas
	private int x, y; // punto inicial
	private int u, v; // punto final
	private int p, q; // movimiento
	
	private int nMovimientos = 0;
	private ArrayList<Integer> moves = new ArrayList<>(); 

	private boolean move = true; // empezar horizontal

	private int[][] mtrInicial;
	private int[][] mtrFinal;

	
	/**
	 * Constructor 
	 * @param filas
	 * @param col
	 * @param x
	 * @param y
	 * @param u
	 * @param v
	 */
	public Conejo(int filas, int col, int x, int y, int u, int v) {
		super();
		this.filas = filas;
		this.col = col;
		this.x = x;
		this.y = y;
		this.u = u;
		this.v = v;

		mtrInicial = new int[filas][col];
		mtrFinal = new int[filas][col];

		llenarMatriz(mtrInicial, true);
		llenarMatriz(mtrFinal, false);

		imprimirMatriz(mtrInicial);
		System.out.println("    . . . .   ");
		imprimirMatriz(mtrFinal);

	}

	/**
	 * Metodo para generar el movimiento del conejo dentro del campo 
	 * @param p
	 * @param q
	 */
	public void movimiento(int p, int q) {

		if (esSeguro(p, q)) {
			System.out.println(
					"Ingrese un movimiento dentro de los limites \n" + "La matriz es de" + filas + " X " + col);
		} else {

		}

	}

	
	/**
	 * Metodo para realizar un moviemiento vertical 
	 * @param x
	 * @param y
	 * @param matriz
	 */

	public void vertical(int x, int y, int[][] matriz) {

		int arriba = x - 1;
		int abajo = x + 1;

		int random = (int) Math.random();

		
		if (arriba == u && y == v) {
			nMovimientos++;
			
			
  		}else if (abajo == u && y == v) {
			
		}else if (esSeguro(arriba, y) && random == 1) {
			
			matriz[arriba][y] = -1;

		} else {

			matriz[abajo][y] = -1;

		}

	}

	/**
	 * Metodo para realizar un metodo horizontal 
	 * @param x
	 * @param y
	 * @param matriz
	 */
	public void horizontal(int x, int y, int[][] matriz) {

		int iz = y - 1;
		int der = y + 1;

		int random = (int) Math.random();
		
		if (esSeguro(x, der) && random == 1) {

			matriz[x][der] = -1;

		} else {

			if (esSeguro(x, iz)) {
				matriz[x][iz] = -1;
			} else {
				matriz[x][der] = -1;
			}

		}

	}
	
	

	/**
	 * Metodo que ayuda a comprobar que el movimiento no se pase del limite 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean esSeguro(int x, int y) {
		return (x >= 0 && x < filas && y >= 0 && y < col);
	}

	
	/**
	 * Metodo para llenar la matriz con la condicion incicial y final 
	 * @param matriz
	 * @param tipo
	 */
	public void llenarMatriz(int[][] matriz, boolean tipo) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				// Si es verdadero llena matriz inicial
				if (i == x && j == y && tipo) {

					matriz[i][j] = -1;
				}

				// Si es falso llena la matriz final
				else if (i == u && j == v && !tipo) {

					matriz[i][j] = -1;

				} else {
					matriz[i][j] = 0;
				}

			}
		}
	}
	
	/**
	 * Metodo para imprimir matriz 
	 * @param matriz
	 */

	public void imprimirMatriz(int[][] matriz) {

		for (int x = 0; x < matriz.length; x++) {
			System.out.print("|");
			for (int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
				if (y != matriz[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}

	
	/**
	 * Metodo para realizar validaciones en el movimiento del conejo 
	 * @param matriz
	 * @param matrizFinal
	 */
	public void moverConejo(int[][] matriz, int[][] matrizFinal) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				if (matriz[i][j] == -1) {
					matriz[i][j] = 1;
				}

			}
		}

	}

	/**
	 * @return the filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * @param filas the filas to set
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the u
	 */
	public int getU() {
		return u;
	}

	/**
	 * @param u the u to set
	 */
	public void setU(int u) {
		this.u = u;
	}

	/**
	 * @return the v
	 */
	public int getV() {
		return v;
	}

	/**
	 * @param v the v to set
	 */
	public void setV(int v) {
		this.v = v;
	}

	/**
	 * @return the p
	 */
	public int getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(int p) {
		this.p = p;
	}

	/**
	 * @return the q
	 */
	public int getQ() {
		return q;
	}

	/**
	 * @param q the q to set
	 */
	public void setQ(int q) {
		this.q = q;
	}

	/**
	 * @return the nMovimientos
	 */
	public int getnMovimientos() {
		return nMovimientos;
	}

	/**
	 * @param nMovimientos the nMovimientos to set
	 */
	public void setnMovimientos(int nMovimientos) {
		this.nMovimientos = nMovimientos;
	}

	/**
	 * @return the moves
	 */
	public ArrayList<Integer> getMoves() {
		return moves;
	}

	/**
	 * @param moves the moves to set
	 */
	public void setMoves(ArrayList<Integer> moves) {
		this.moves = moves;
	}

	/**
	 * @return the move
	 */
	public boolean isMove() {
		return move;
	}

	/**
	 * @param move the move to set
	 */
	public void setMove(boolean move) {
		this.move = move;
	}

	/**
	 * @return the mtrInicial
	 */
	public int[][] getMtrInicial() {
		return mtrInicial;
	}

	/**
	 * @param mtrInicial the mtrInicial to set
	 */
	public void setMtrInicial(int[][] mtrInicial) {
		this.mtrInicial = mtrInicial;
	}

	/**
	 * @return the mtrFinal
	 */
	public int[][] getMtrFinal() {
		return mtrFinal;
	}

	/**
	 * @param mtrFinal the mtrFinal to set
	 */
	public void setMtrFinal(int[][] mtrFinal) {
		this.mtrFinal = mtrFinal;
	}
	
	

}
