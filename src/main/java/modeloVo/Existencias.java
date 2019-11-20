package modeloVo;

import java.util.ArrayList;

public class Existencias {
	private String nombre;
	private double precioCompra;
	private int stock;
	private double total;
	
	public Existencias() {}

	public Existencias(String nombre, int stock, double precioCompra, double total) {
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.stock = stock;
		this.total = total;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
