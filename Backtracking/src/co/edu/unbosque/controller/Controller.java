package co.edu.unbosque.controller;

import co.edu.unbosque.model.Menu;
import co.edu.unbosque.model.Nutricionista;
import co.edu.unbosque.view.View;

public class Controller {
	private View vista;

	public Controller() {
		vista = new View();
		funcionar();
	}

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

	public void llenarProblemaMenu() {
		int cantidad = vista.leerDatoEntero("Por favor ingrese la cantidad de alimentos en el menu");
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
		int maxCalorias= vista.leerDatoEntero("Ingrese las colorias maximas");
		Nutricionista m_base = new Nutricionista(maxCalorias, menu.length);
		Nutricionista m_opt = new Nutricionista(maxCalorias, menu.length);
		String a = m_base.seleccionarBackT(m_base, m_opt, false, menu);
		vista.imprimirMensaje("Teniendo maximo "+ maxCalorias+ " calorias, se tiene"+a);
	}
}
