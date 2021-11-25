package co.edu.unbosque.controller;

import co.edu.unbosque.view.View;

public class Controller {
	private View vista;
	public Controller() {
		vista= new View();
		funcionar();
	}
	public void funcionar() {
		int num= vista.leerDatoEntero("ingrese numero de elementos de serie de fibonacci");
		
	}
}
