/**
* El package que contiene la clase
*/
package co.edu.unbosque.controller;

import java.util.Scanner;

import co.edu.unbosque.model.Conejo;
import co.edu.unbosque.model.Menu;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Nutricionista;
import co.edu.unbosque.view.View;
/**
 * Clase Controller, clase que permite la conexion entre la clase view y las clases del package model
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class Controller {
	private View vista;
	private Equipo equipo;
	/**
	 * Constructor de controller
	 */
	public Controller() {
		vista = new View();
		equipo = new Equipo();

		funcionar();
	}
	/**
	 * Metodo que empieza el programa
	 */
	public void funcionar() {
		int a = vista.leerDatoEntero(
				"Por favor ingresa que cual de los algoritmos quieres hacer \n1. Nutricionista va a un restaurante(Backtracking) \n2. Liga de futbol Colombiana (Backtracking)\n3. Saltos de un conejo(Rama y Poda)\n4 Cualquier otro numero para salir");
		switch (a) {
		case 1: {
			llenarProblemaMenu();
			break;
		}
		case 2: {
			llenarMenu2();

			break;
		}
		case 3: {
		

			int campo = vista.leerDatoEntero("Ingrese el tama駉 del campo");

			// Punto inicial (X,Y)
			int inicioX = vista.leerDatoEntero("Ingrese el punto inicial X ");
			int inicioY = vista.leerDatoEntero("Ingrese el punto inicial Y");

			// Punto Final (X,Y)
			int finalX = vista.leerDatoEntero("Ingrese el punto final X ");
			int finalY = vista.leerDatoEntero("Ingrese el punto final Y");

			Conejo conejo = new Conejo(campo, campo, inicioX, inicioY, finalX, finalY);
		}
		default:
			vista.imprimirMensaje("Hasta Luego!");
			System.exit(0);
		}

	}
/**
 * Metodo que captura los valores necesarios para el problema del nutricionista y redirecciona a las clases del modelo necesarias
 */
	public void llenarProblemaMenu() {
		int cantidad = vista.leerDatoEntero("Por favor ingrese la cantidad de alimentos en el menu");
		while(cantidad<=2) {
			 cantidad = vista.leerDatoEntero("Por favor ingrese la cantidad de alimentos en el menu mayor a 2");
		}
		Menu[] menu = new Menu[cantidad];
		for (int i = 0; i < cantidad; i++) {
			String comida = vista.leerdato("Ingrese el nombre de la comida");
			for (int j = 0; j < menu.length; j++) {
				if (menu[j] != null) {
					while (menu[j].getComida().equals(comida.toLowerCase())) {
						vista.imprimirMensajeAd("Ya existe ese nombre en el menu");
						comida = vista.leerdato("Ingrese nuevamente el nombre de la comida");
					}
				}
			}
			int calorias = vista.leerDatoEntero("Por favor la calorias de la comida " + comida);
			menu[i]=new Menu(comida.toLowerCase(),calorias);
		}
		int minCalorias= vista.leerDatoEntero("Ingrese las colorias minimas");
		Nutricionista m_base = new Nutricionista(minCalorias, menu.length);
		Nutricionista m_opt = new Nutricionista(minCalorias, menu.length);
		String a = m_base.realizarBackTracking(m_base, m_opt, false, menu);
		vista.imprimirMensaje("Teniendo minimo "+ minCalorias+ " calorias, se tiene"+a);
	}

	/**
	 * Agregando tama帽o n equipos, m arbitros
	 * Backtracking
	 */
	public void llenarMenu2() {
		int n = vista.leerDatoEntero("Por favor ingrese la cantidad de Equipos que van a jugar");
		if(n%2 != 0){
			vista.imprimirMensaje("La cantidad de equipos debe ser par");
			llenarMenu2();
		}
		int m = vista.leerDatoEntero("Por favor ingrese la cantidad de Arbitros.");
		if(m < n%2){
			vista.imprimirMensaje("La cantidad de arbitros debe ser mayor a la cantidad de equipos entre 2");
			llenarMenu2();
		}
		int opcion = vista.leerDatoEntero("Escoga una opci贸n \n1. Ingresar la puntuaci贸n de cada equipo a cada arbitro (de 0 a 10).\n2.Salir (cualquier numero)");
		switch (opcion) {
		case 1: {
			var puntuaciones = ingresarPuntuaciones(n,m);
				int[][] combinaciones = {{0,1},{2,3}};
				System.out.println("Jornada 1"+equipo.imprimirArray(equipo.enfrentamientoJornada(puntuaciones, combinaciones, n, m))); 
				int [][] combinaciones2 = {{0,2},{1,3}};
				System.out.println("Jornada 2"+equipo.imprimirArray(equipo.enfrentamientoJornada(puntuaciones, combinaciones2, n, m)));
				int [][] combinaciones3 = {{0,3},{1,2}};
				System.out.println("Jornada 3"+equipo.imprimirArray(equipo.enfrentamientoJornada(puntuaciones, combinaciones3, n, m)));

			break;
		}
		default:
			vista.imprimirMensaje("Hasta luego!");
			System.exit(0);
		}
	}
	/**
	 * Agregando puntuacion por equipo a los arbitros
	 * @param n -> cantidad de equipos
	 * @param m -> cantidad de arbitros
	 */
	public int[][] ingresarPuntuaciones(int n,int m){
		int[][] puntuaciones = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				puntuaciones[i][j] = vista.leerDatoEntero("Por favor ingrese la puntuaci贸n del equipo " + (j + 1) + " al arbitro " + (i + 1));
				while(puntuaciones[i][j] < 0 || puntuaciones[i][j] > 10){
					vista.imprimirMensaje("La puntuaci贸n debe estar entre 0 y 10");
					puntuaciones[i][j] = vista.leerDatoEntero("Por favor ingrese la puntuaci贸n del equipo " + (j + 1) + " al arbitro " + (i + 1));
				}
			}
		}
		return puntuaciones;
	}
}