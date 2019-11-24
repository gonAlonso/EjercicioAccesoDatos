package modeloVo;

public class Factura {
	private double subtotal;
	private double descuento;
	private double baseImponible;
	private double iva;
	private double total;
	public Factura(double subtotal, double descuento, double baseImponible, double iva, double total) {
		super();
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.baseImponible = baseImponible;
		this.iva = iva;
		this.total = total;
	}
	public Factura() {
		super();
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
	
	
}
