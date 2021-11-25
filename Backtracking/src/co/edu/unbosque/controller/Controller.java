package co.edu.unbosque.controller;

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

			break;
		}
		case 2: {

			break;
		}
		case 3: {

			break;
		}
		default:
			vista.imprimirMensaje("¡Hasta luego!");
			System.exit(0);
		}

	}
}
