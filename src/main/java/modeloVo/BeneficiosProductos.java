package modeloVo;

import java.util.ArrayList;

public class BeneficiosProductos {
	private int id;
	private String nombreProducto;
	private double precioCompra;
	private double precioVenta;
	private int cantidad;
	private double beneficio;
	private String nombreProveedor;
	private String telefono;
	private String web;
	
	public BeneficiosProductos() {
	}

	public BeneficiosProductos(int id, String producto, double precioCompra, double precioVenta, int cantidad, double beneficio,
			String proveedor, String telefono, String web) {
		this.id = id;
		this.nombreProducto = producto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
		this.beneficio = beneficio;
		this.nombreProveedor = proveedor;
		this.telefono = telefono;
		this.web = web;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(double beneficio) {
		this.beneficio = beneficio;
	}

	public String getProveedor() {
		return this.nombreProveedor;
	}

	public void setProveedor(String proveedor) {
		this.nombreProveedor = proveedor;
	}
	
	public String getProducto() {
		return this.nombreProducto;
	}

	public void setProducto(String prod) {
		this.nombreProducto = prod;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
	
	public static ArrayList<Producto> beneficioProductos( ) { return null; }
}
