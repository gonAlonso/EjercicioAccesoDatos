package modeloVo;

import java.util.ArrayList;

public class Producto {
	private int id;
	private String nombre;
	private double precioCompra;
	private int stock;
	private String nifProveedor;
	private double precioVenta;
	private int stockMinimo;
	private double iva;
	
	public Producto() {}

	public Producto(int id, String nombre, double precioCompra, int stock, String nifProveedor, double precioVenta,
			int stockMinimo, double iva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.stock = stock;
		this.nifProveedor = nifProveedor;
		this.precioVenta = precioVenta;
		this.stockMinimo = stockMinimo;
		this.iva = iva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNifProveedor() {
		return nifProveedor;
	}

	public void setNifProveedor(String nifProveedor) {
		this.nifProveedor = nifProveedor;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
}
