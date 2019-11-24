package modeloVo;

public class LineaFacturaMes {
	private int numero;
	private String fecha;
	private double baseImponible;
	private double iva;
	private double total;
	
	
	
	public LineaFacturaMes() {
		super();
	}
	public LineaFacturaMes(int numero, String fecha, double baseImponible, double iva, double total) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.baseImponible = baseImponible;
		this.iva = iva;
		this.total = total;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
