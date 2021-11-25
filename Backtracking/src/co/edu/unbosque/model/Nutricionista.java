package co.edu.unbosque.model;

public class Nutricionista {
	private int maxcalorias;
	private Menu[] menu;
	private int calorias;
	private String comida;

	public Nutricionista(int calorias, int cantidadPlatos) {
		this.maxcalorias = calorias;
		this.menu = new Menu[cantidadPlatos];
		this.calorias = 0;
		this.comida = "";
	}

	public String seleccionarBackT(Nutricionista base, Nutricionista optimo, boolean completo, Menu[] m) {
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
					if (getMaxcalorias() >= base.getCalorias()  + m[i].getCalorias() ) {
						base.agregarPlato(m[i]);
						this.seleccionarBackT(base, optimo, false, m);
						base.eliminarPlato(m[i]);
					} else {
						this.seleccionarBackT(base, optimo, true, m);
					}
				}
			}
		}
		return optimo.toString();
	}

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

	public void vaciar() {
		this.calorias = 0;
		this.comida = "";
		for (int i = 0; i < this.menu.length; i++) {
			menu[i] = null;
		}
	}

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

	public boolean existePlato(Menu menu) {
		for (int i = 0; i < this.menu.length; i++) {
			if (this.menu[i] != null && this.menu[i].equals(menu)) {
				return true;
			}
		}
		return false;
	}

	public int getMaxcalorias() {
		return maxcalorias;
	}

	public void setMaxcalorias(int maxcalorias) {
		this.maxcalorias = maxcalorias;
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

	@Override
	public String toString() {
		String resultado = "";
		resultado += "Las calorias totales: " + getCalorias() + "\n";
		resultado += "El nombre de los platos a pedir: \n" + getComida();
		return resultado;
	}


}
