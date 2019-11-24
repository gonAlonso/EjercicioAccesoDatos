package vista;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import controlador.Controlador;
import modeloVo.ProductosBajoMinimo;

public class ModeloTablaProductosMinimos extends AbstractTableModel {
	
	private ArrayList<ProductosBajoMinimo> listaProductos= null;
	private ArrayList<String> nombresColumnas = null;
	//private double resultados[];
	
	
	// Añadir nf.format
	public ModeloTablaProductosMinimos() {
		super();
		nombresColumnas = new ArrayList<String>();

		nombresColumnas.add( "Codigo" );
		nombresColumnas.add( "Producto" );
		nombresColumnas.add( "Precio Compra" );
		nombresColumnas.add( "Precio Venta" );
		nombresColumnas.add( "Stock" );
		nombresColumnas.add( "Proveedor" );
		nombresColumnas.add( "Telefono" );
		
		listaProductos = new ArrayList<ProductosBajoMinimo>();
	}
	
	
	@Override
	public Object getValueAt(int nP, int columnIndex) {
		//Departamento dep = departamentos.get( nDep);
		ProductosBajoMinimo prod = listaProductos.get( nP );

		switch ( columnIndex ) {
			case 0: return prod.getCodigo();
			case 1: return prod.getNombre();
			case 2: return prod.getPrecioCompra();
			case 3: return prod.getStock();
			case 4: return prod.getPrecioVenta();
			case 5: return prod.getNombreProveedor();
			case 6: return prod.getTelefono();
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
		listaProductos = Controlador.getListaStockBajoMinimo();
	}
}
