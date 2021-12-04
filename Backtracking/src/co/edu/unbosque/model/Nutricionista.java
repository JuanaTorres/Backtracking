/**
 * El package que contiene la clase
 */
package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Clase Nutricionista que contiene los metodos que permite realizar el backtraking del problema del nutricionista
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class Nutricionista {
	private int mincalorias;
	private Menu[] menu;
	private int calorias;
	private String comida;
	private ArrayList<Integer> r;
/**
 * Constructor
 * @param calorias, minimas calorias que consume
 * @param cantidadPlatos, el numero de platos en el menu
 */
	public Nutricionista(int calorias, int cantidadPlatos) {
		this.mincalorias = calorias;
		this.menu = new Menu[cantidadPlatos];
		this.calorias = 0;
		this.comida = "";
		this.r = new ArrayList<>();
	}
	/**
	 * Metodo que redirecciona al metodo seleccionarBackT que da una dolucion, en caso de no ser el esperado cambia alguno datos para el ajuste
	 * @param base, objeto nutricionista que posee los datos cambiantes
	 * @param optimo, objeto nutricionista que posee los valores optimoscon la posible solucion
	 * @param completo, boolean para saber cuando el ejercicio completo
	 * @param m, el menu que tiene el nutricionista
	 * @return el string de los valores en optimo
	 */
	public String realizarBackTracking(Nutricionista base, Nutricionista optimo, boolean completo, Menu[] m) {
		optimo=this.seleccionarBackT(base, optimo, false, m);
		if(optimo==null||optimo.getCalorias()==0||getMincalorias() != optimo.getCalorias()) {
			System.out.println("AA");
			ArrayList<Integer> calorias = new ArrayList<>();
			ArrayList<Integer> vacio = new ArrayList<>();
			for (int i = 0; i < m.length; i++) {
					calorias.add(m[i].getCalorias());
			}
			combinacionBack(calorias,vacio, 0);
			Collections.sort(r);
			setMincalorias(r.get(0));
			Nutricionista m_base = new Nutricionista(r.get(0), menu.length);
			Nutricionista m_opt = new Nutricionista(r.get(0), menu.length);
			optimo=this.seleccionarBackT(m_base, m_opt, false, m);
		}
		return optimo.toString();
	}
	/**
	 * Metodo que encuentra los valores para optimo y los platos que completan o superan minimamente el minimo de calorias
	 * @param base, objeto nutricionista que posee los datos cambiantes
	 * @param optimo, objeto nutricionista que posee los valores optimoscon la posible solucion
	 * @param completo, boolean para saber cuando el ejercicio completo
	 * @param m, el menu que tiene el nutricionista
	 * @return el string de los valores en optimo
	 */
	public Nutricionista seleccionarBackT(Nutricionista base, Nutricionista optimo, boolean completo, Menu[] m) {
		
		if (completo) {
			if (base.getCalorias() > optimo.getCalorias()) {
				Menu[] mbase = base.getMenu();
				optimo.vaciar();
				for (Menu m1 : mbase) {
					if (m1 != null) {
						optimo.agregarPlato(m1);
					}
				}
			}

		} else {
			for (int i = 0; i < m.length; i++) {
				if (!base.existePlato(m[i])) {
					if (getMincalorias() >= base.getCalorias()  + m[i].getCalorias() ) {
						base.agregarPlato(m[i]);
						this.seleccionarBackT(base, optimo, false, m);
						base.eliminarPlato(m[i]);
					} else {
						this.seleccionarBackT(base, optimo, true, m);
					}
				}
			}
		}
		
		return optimo;
	}
	/**
	 * Metodo que encuentra todas las sumas posibles de las calorias de los platos que superan al minimo de calorias
	 * @param calorias, lista de las calorias de los platos
	 * @param vacio, array vacio para llenar con las calorias
	 * @param suma, valor la sumatoria de los platos
	 */
	public  void combinacionBack(ArrayList<Integer> calorias,ArrayList<Integer> vacio, int suma) {
		if (suma >= getMincalorias()) {
			this.r.add(suma);
		} else {

			for (int i = 0; i < calorias.size(); i++) {
				suma+=calorias.get(i);
				if (suma <= getMincalorias()) {
					vacio.add(calorias.get(i));
					combinacionBack( calorias, vacio,suma);
					vacio.remove(vacio.indexOf(calorias.get(i)));
				}else if (suma > getMincalorias()) {
					vacio.add(calorias.get(i));
					combinacionBack( calorias, vacio,suma);
					vacio.remove(vacio.indexOf(calorias.get(i)));
				}
				suma-=calorias.get(i);
			}
		}
	}
/**
 * Metodo que agrega al atributo menu los valores en el parametro
 * @param menu, objeto menu que se ingresa al atributo menu
 */
	public void agregarPlato(Menu menu) {
		for (int i = 0; i < this.menu.length; i++) {
			if (this.menu[i] == null) {
				this.menu[i] = menu;
				this.calorias += menu.getCalorias();
				this.comida += menu.getComida() + "\n";
				break;
			}
		}
	}
/**
 * Metodo que borra los valores en menu
 */
	public void vaciar() {
		this.calorias = 0;
		this.comida = "";
		for (int i = 0; i < this.menu.length; i++) {
			menu[i] = null;
		}
	}
/**
 * Metodo que busca y borra en menu un objeto
 * @param menu, objeto menu
 */
	public void eliminarPlato(Menu menu) {
		for (int i = 0; i < this.menu.length; i++) {
			if (this.menu[i].equals(menu)) {
				this.menu[i] = null;
				this.calorias -= menu.getCalorias();
				this.comida.replace(menu.getComida(), "");
				break;

			}
		}
	}
/**
 * Metodo que valida si en menu existe ese objeto
 * @param menu, objeto menu
 * @return boolean, true si existe o false si no existe
 */
	public boolean existePlato(Menu menu) {
		for (int i = 0; i < this.menu.length; i++) {
			if (this.menu[i] != null && this.menu[i].equals(menu)) {
				return true;
			}
		}
		return false;
	}
/**
 *Setters and Getters 
  */
	public int getMincalorias() {
		return mincalorias;
	}

	public void setMincalorias(int maxcalorias) {
		this.mincalorias = maxcalorias;
	}

	public Menu[] getMenu() {
		return menu;
	}

	public void setMenu(Menu[] menu) {
		this.menu = menu;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getComida() {
		return comida;
	}

	public void setComida(String comida) {
		this.comida = comida;
	}
/**
 * To String de la clase
 */
	@Override
	public String toString() {
		String resultado = "\n";
		resultado += "Las calorias totales: " + getCalorias() + "\n";
		resultado += "El nombre de los platos a pedir: \n" + getComida();
		return resultado;
	}


}