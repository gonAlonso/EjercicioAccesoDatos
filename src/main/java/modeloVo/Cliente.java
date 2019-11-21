package modeloVo;

public class Cliente {
	private String nif;
	private String nombre;
	private String calle;
	private String codPostal;
	private String ciudad;
	private String contacto;
	private double clDescuento;
	public Cliente() {}
	public Cliente(String nif, String nombre, String calle, String codPostal, String ciudad, String contacto,
			double clDescuento) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.calle = calle;
		this.codPostal = codPostal;
		this.ciudad = ciudad;
		this.contacto = contacto;
		this.clDescuento = clDescuento;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public double getClDescuento() {
		return clDescuento;
	}
	public void setClDescuento(double clDescuento) {
		this.clDescuento = clDescuento;
	}
	
	@Override
	public String toString() {
		return nombre;
	}	
}
