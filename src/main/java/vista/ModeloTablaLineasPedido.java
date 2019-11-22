package vista;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import controlador.Controlador;
import modeloVo.LineaPedido;
import modeloVo.Pedido;
import modeloVo.ProductosBajoMinimo;

public class ModeloTablaLineasPedido extends AbstractTableModel {
	
	private ArrayList<LineaPedido> listaPedidos= null;
	private ArrayList<String> nombresColumnas = null;
	//private double resultados[];
	
	
	// A�adir nf.format
	public ModeloTablaLineasPedido() {
		super();
		nombresColumnas = new ArrayList<String>();

		nombresColumnas.add( "Codigo" );
		nombresColumnas.add( "Producto" );
		nombresColumnas.add( "Cantidad" );
		nombresColumnas.add( "Precio" );
		nombresColumnas.add( "Importe" );
		listaPedidos = new ArrayList<LineaPedido>();
	}
	
	
	@Override
	public Object getValueAt(int nP, int columnIndex) {
		LineaPedido ped = listaPedidos.get( nP );
		switch ( columnIndex ) {
			case 0: return ped.getIdProd();
			case 1: return ped.getNombreProd();
			case 2: return ped.getCantidad();
			case 3: return ped.getPrecio();
			case 4: return ped.getImporte();
			default: throw new IllegalArgumentException("Unexpected value: " +  columnIndex );
		}
	}

	@Override
	public int getRowCount() {
		return (listaPedidos==null)? 0 : listaPedidos.size();
	}

	@Override
	public int getColumnCount() {
		return nombresColumnas.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return this.nombresColumnas.get(column);
	}
	
	public LineaPedido getLinea(int numPed) {
		return listaPedidos.get( numPed ); 
	}
	
	public void addLinea( LineaPedido lin) {
		listaPedidos.add( lin );
		this.fireTableDataChanged();   		// !! 
	}
	
	public void cargarLineasPedidos(int numPed) {
		listaPedidos = Controlador.getListaLineasPedido( numPed );
	}

	public void clear() {
		listaPedidos.clear();
	}
}
