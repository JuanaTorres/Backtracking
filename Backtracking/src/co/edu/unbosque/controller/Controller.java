/**
* El package que contiene la clase
*/
package co.edu.unbosque.controller;

import co.edu.unbosque.model.Menu;
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
	/**
	 * Constructor de controller
	 */
	public Controller() {
		vista = new View();
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

			break;
		}
		case 3: {

			break;
		}
		default:
			vista.imprimirMensaje("�Hasta luego!");
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
}
