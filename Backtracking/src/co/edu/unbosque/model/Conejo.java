package co.edu.unbosque.model;

import java.awt.List;
import java.util.Iterator;
import java.util.Scanner;

public class Conejo {

	private int filas; // columnas
	private int col; // filas
	private int x, y; // punto inicial
	private int u, v; // punto final
	private int p, q; // movimiento
	

	private int[][] mtrInicial;
	private int[][] mtrFinal;

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


	public void movimiento(int p, int q) {

		if (esSeguro(p, q)) {
			System.out.println(
					"Ingrese un movimiento dentro de los limites \n" + "La matriz es de" + filas + " X " + col);
		} else {

          
		}

	}
	
	
	public void  vertical (int x, int y, int [][] matriz) {
		
		int arriba = x - 1;
		int abajo = x + 1;
		
		
		
	}
	
	public void horizontal (int x, int y, int [][] matriz) {
		
		int iz = y - 1;
		int der =  y + 1;
	
	}
    
	
	
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Ingrese el tamaño del campo");
		int campo = scan.nextInt();

		// Punto inicial (X,Y)
		System.out.println("Ingrese el punto inicial X ");
		int inicioX = scan.nextInt();

		System.out.println("Ingrese el punto inicial Y");
		int inicioY = scan.nextInt();

		// Punto Final (X,Y)
		System.out.println("Ingrese el punto final X ");
		int finalX = scan.nextInt();

		System.out.println("Ingrese el punto final Y");
		int finalY = scan.nextInt();

		Conejo conejo = new Conejo(campo, campo, inicioX, inicioY, finalX, finalY);

	}

		
	
	
	public boolean esSeguro (int x, int y) {
		return (x >= 0 && x < filas && y >= 0 && y < col);
	}
	

	
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

}
