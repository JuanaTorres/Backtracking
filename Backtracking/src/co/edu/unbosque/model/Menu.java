package co.edu.unbosque.model;


/**
 * 
 * @author ACER
 *
 */
public class Menu {
	
	
	private String comida;
	private int calorias;
	
	/**
	 * 
	 * @param comida
	 * @param calorias
	 */
	public Menu(String comida, int calorias) {
		super();
		this.calorias=calorias;
		this.comida=comida;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getComida() {
		return comida;
	}
	
	/**
	 * 
	 * @param comida
	 */
	public void setComida(String comida) {
		this.comida = comida;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	@Override
	public String toString() {
		return "Menu [comida=" + comida + ", calorias=" + calorias + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (calorias != other.calorias)
			return false;
		if (comida == null) {
			if (other.comida != null)
				return false;
		} else if (!comida.equals(other.comida))
			return false;
		return true;
	}
	
}