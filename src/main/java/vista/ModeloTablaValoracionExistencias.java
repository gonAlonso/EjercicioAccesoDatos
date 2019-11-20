package vista;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import controlador.Controlador;
import modeloVo.BeneficiosProductos;
import modeloVo.Existencias;
import modeloVo.ProductosBajoMinimo;

public class ModeloTablaValoracionExistencias extends AbstractTableModel {
	
	private ArrayList<Existencias> listaProductos= null;
	private ArrayList<String> nombresColumnas = null;
	
	// Añadir nf.format
	public ModeloTablaValoracionExistencias() {
		super();
		nombresColumnas = new ArrayList<String>();
		nombresColumnas.add( "Producto" );
		nombresColumnas.add( "Stock" );
		nombresColumnas.add( "Precio de Compra" );
		nombresColumnas.add( "Total" );
		
		listaProductos = new ArrayList<Existencias>();
	}
	
	
	@Override
	public Object getValueAt(int nP, int columnIndex) {
		Existencias prod = listaProductos.get( nP );

		switch ( columnIndex ) {
			case 0: return prod.getNombre();
			case 1: return prod.getStock();
			case 2: return prod.getPrecioCompra();
			case 3: return prod.getTotal();
			default: throw new IllegalArgumentException("Unexpected value: " +  columnIndex );
		}
	}

	@Override
	public int getRowCount() {
		return listaProductos.size();
	}

	@Override
	public int getColumnCount() {
		return nombresColumnas.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return this.nombresColumnas.get(column);
	}
	
	public void cargarProductos() {
		listaProductos = Controlador.getValoracionExistencias();
		System.out.println("Existencias cargadas");
	}
}
