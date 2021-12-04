/**
 * El package que contiene la clase
 */
package co.edu.unbosque.model;
/**
 * Clase View que contiene los metodos que permite mostrar mensajes o capturar datos.
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class Menu {
	private String comida;
	private int calorias;
	/**
	 * Constructor
	 * @param comida, nombre del plato
	 * @param calorias, numero de calorias del plato
	 */
	public Menu(String comida, int calorias) {
		super();
		this.calorias=calorias;
		this.comida=comida;
	}
	/**
	 * Setter and getters
	 * 
	 */
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
}