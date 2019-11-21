package modeloVo;

public class LineaPedido {
	private int liId;
	private int idProd;
	private int cantidad;
	private String nombreProd;
	private double precio;
	private double importe;

	public LineaPedido() {
	}

	public LineaPedido(int liId, int idProd, int cantidad, String nombreProd, double precio,
			double importe) {
		super();
		this.liId = liId;
		this.idProd = idProd;
		this.cantidad = cantidad;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.importe = importe;
	}

	public int getLiId() {
		return liId;
	}

	public void setLiId(int liId) {
		this.liId = liId;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
}
