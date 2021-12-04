/**
 * El package que contiene la clase
 */
package co.edu.unbosque.view;

import javax.swing.JOptionPane;
/**
 * Clase View que contiene los metodos que permite mostrar mensajes o capturar datos.
 * 
 * @authors Paula Andre Anaya Ramirez, Juana
 *          Valentina Torres Parrado and Andres Galvis Bolivar
 *          
 * @version 1.0
 *
 */
public class View {
	/**
	 * Constructor
	 */
	public View() {
		
	}
	/**
	 * Imprime un mensaje
	 * @param m, el mensaje a mostrar
	 */
	public void imprimirMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	/**
	 * Imprime un mensaje de advertencia
	 * @param m, Mensaje a mostrar
	 */
	public void imprimirMensajeAd(String m) {
		JOptionPane.showMessageDialog(null, m,"Backtracking, Rama y poda",
				JOptionPane.WARNING_MESSAGE);
	}
	/**
	 * Metodo que captura el dato tipo numero entero
	 * @param m, mensaje a mostrar
	 * @return el dato tipo int 
	 */
	public int leerDatoEntero(String m) {
		int cambio = 0;
		while (cambio == 0) {
			String aux = (JOptionPane.showInputDialog(null, m, "Backtracking, Rama y poda",
					JOptionPane.INFORMATION_MESSAGE));
			try {
				cambio = Integer.parseInt(aux);
			} catch (NumberFormatException e) {
				cambio = 0;
				imprimirMensaje("Debes ingresar un número");
			}
		}
		return cambio;
	}
	/**
	 * Metodo que captura el dato tipo string
	 * @param m, mensaje a mostrar
	 * @return el dato  
	 */
	public String leerdato(String m) {
		String aux = (JOptionPane.showInputDialog(null, m, "Backtracking, Rama y poda",
				JOptionPane.INFORMATION_MESSAGE));
		return aux;
	}
}
