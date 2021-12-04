package co.edu.unbosque.model;

import java.util.ArrayList;

public class Equipo {
        ArrayList<Integer> equipo;
    public Equipo() {
        equipo   = new ArrayList<>();
        combinatoria2(ingresarPuntuacionesAleatorias(4,3), 4, 0, equipo);
    }
    /**
	 * Agregar puntuaciones aleatorias a los arbitros
	 * @param n -> cantidad de equipos
	 * @param m -> cantidad de arbitros
	 */
	public int[][] ingresarPuntuacionesAleatorias(int n, int m){
		int[][] puntuaciones = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				puntuaciones[i][j] = (int) (Math.random() * 10);
			}
		}
		return puntuaciones;
	}
    /**
	 * Se realizan las sumas del puntaje por equipos hacia los arbitros
	 * y se determina el arbitro con mayor puntaje, por cada enfrentamiento.
	 * @param puntuaciones las puntuaciones de cada arbitro por equipo
	 * @param jornada -> equipox vs equipoy
	 * @param n -> equipos
	 * @param m -> arbitros
	 * @return
	 */
	public int[] enfrentamientoJornada(int[][] puntuaciones, int[][] jornada, int n, int m) {
		int arbitro_partido[] = new int[n/2]; 
		for (int i = 0; i < n/2; i++) {
			var x = 0;

			for (int j = 0; j < m; j++) {
				var v = puntuaciones[j][jornada[i][0]] + puntuaciones[j][jornada[i][1]];				
				if(x < v ) {
					x = v;
					arbitro_partido[i] = j+1; 
				}
			}
		}		
		return arbitro_partido;
	}
	public String imprimirArray(int[] n) {
		String r ="";
		for (int i = 0; i < n.length; i++) {
			r+=" | "+n[i];
		}
		return r;
	}
	/**
	 * Generando algoritcmo Backtracking para generar todas las combinatorias
	 * Ejemplo: Total de equipos: 4
	 * Jornada 1 {1,2,3,4}
	 * Jornada 2 {1,3,2,4}
	 * Jornada 3 {1,4,2,3}
	 * @param puntuaciones
	 * @param n -> cantidad de equipos
	 * @param m -> cantidad de arbitros
	 */
	public void combinatoria2(int[][] puntuaciones, int n, int sum, ArrayList<Integer> equipo) {
		if(sum == n){
            for (Integer integer : equipo) {
                System.out.print(equipo);
            }
            System.out.println("\n");
		}else{
			for (int i = 0; i < n; i++) {
				sum += 1;
				if(sum <= n){
                    equipo.add(i+1);
					combinatoria2(puntuaciones, n,  sum, equipo);
                    equipo.remove(equipo.indexOf(i));
                }
				sum +=-1;
			}
		}
	}
    public static void main(String[] args) {
        Equipo e = new Equipo();
     
    }
}
