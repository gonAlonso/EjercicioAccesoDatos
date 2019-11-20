package modeloVo;

public class Pedido {
	private int numPedido;
	private String fecha;
	private String nifCliente;
	private double descuento;
	
	public Pedido(int numPedido, String fecha, String nifCliente, double descuento) {
		this.numPedido = numPedido;
		this.fecha = fecha;
		this.nifCliente = nifCliente;
		this.descuento = descuento;
	}
	public Pedido() {}
	public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNifCliente() {
		return nifCliente;
	}
	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
}
