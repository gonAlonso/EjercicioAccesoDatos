package vista;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import controlador.Controlador;
import modeloVo.LineaPedido;
import modeloVo.Pedido;
import modeloVo.ProductosBajoMinimo;

public class ModeloTablaPedidos extends AbstractTableModel {
	
	private ArrayList<Pedido> listaPedidos= null;
	private ArrayList<String> nombresColumnas = null;
	//private double resultados[];
	
	
	// A�adir nf.format
	public ModeloTablaPedidos() {
		super();
		nombresColumnas = new ArrayList<String>();

		nombresColumnas.add( "Codigo" );
		nombresColumnas.add( "Producto" );
		nombresColumnas.add( "Cantidad" );
		nombresColumnas.add( "Precio" );
		nombresColumnas.add( "Importe" );
		listaPedidos = new ArrayList<Pedido>();
	}
	
	
	@Override
	public Object getValueAt(int nP, int columnIndex) {
		Pedido ped = listaPedidos.get( nP );

		switch ( columnIndex ) {
			/*case -1: return ped.
			case 0: return ped.getCodigo();
			case 1: return ped.getNombre();
			case 2: return ped.getCantidad();
			case 3: return ped.getPrecio();
			case 4: return ped.getImporte();
			*/
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
	
	public void cargarPedidos(int numPed) {
		//listaPedidos = Controlador.getListaPedidos();
		System.out.println("UPDATE TABLA LINEAS PEDIDOS");
	}
}
