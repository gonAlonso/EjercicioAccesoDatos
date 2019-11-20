package modeloDao;

import java.util.ArrayList;

import modeloVo.Cliente;
import modeloVo.Producto;

public class Factura {
	private double subtotal;
	private double descuento;
	private double baseImponible;
	private double iva;
	private double total;
	private ArrayList<Producto> listaProductos;
	private Cliente cliente;
	public Factura() {}
	public Factura(double subtotal, double descuento, double baseImponible, double iva, double total,
			ArrayList<Producto> listaProductos, Cliente cliente) {
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.baseImponible = baseImponible;
		this.iva = iva;
		this.total = total;
		this.listaProductos = listaProductos;
		this.cliente = cliente;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getBaseImponible() {
		return baseImponible;
	}
	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
