package modeloVo;

import java.util.ArrayList;

public class Proveedor {
	private String nif;
	private String nombre;
	private String calle;
	private int codPostal;
	private String ciudad;
	private int telefono;
	private String web;
	
	public Proveedor() {}
	public Proveedor(String nif, String nombre, String calle, int codPostal, String ciudad, int telefono, String web) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.calle = calle;
		this.codPostal = codPostal;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.web = web;
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
	public int getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
