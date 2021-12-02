package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	public View() {
		
	}
	public void imprimirMensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	public void imprimirMensajeAd(String m) {
		JOptionPane.showMessageDialog(null, m,"Backtracking, Rama y poda",
				JOptionPane.WARNING_MESSAGE);
	}
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
	public String leerdato(String m) {
		String aux = (JOptionPane.showInputDialog(null, m, "Backtracking, Rama y poda",
				JOptionPane.INFORMATION_MESSAGE));
		return aux;
	}
}
