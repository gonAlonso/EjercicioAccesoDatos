package vista;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import controlador.Controlador;
import modeloVo.BeneficiosProductos;
import modeloVo.ProductosBajoMinimo;

public class ModeloTablaBeneficiosProductos extends AbstractTableModel {
	
	private ArrayList<BeneficiosProductos> listaProductos= null;
	private ArrayList<String> nombresColumnas = null;
	
	// A�adir nf.format
	public ModeloTablaBeneficiosProductos() {
		super();
		nombresColumnas = new ArrayList<String>();
		nombresColumnas.add( "Producto" );
		nombresColumnas.add( "Precio de Compra" );
		nombresColumnas.add( "Precio de Venta" );
		nombresColumnas.add( "Cantidad" );
		nombresColumnas.add( "Beneficio" );
		nombresColumnas.add( "Proveedor" );
		nombresColumnas.add( "tel�fono" );
		nombresColumnas.add( "Web" );
		
		listaProductos = new ArrayList<BeneficiosProductos>();
	}
	
	
	@Override
	public Object getValueAt(int nP, int columnIndex) {
		//Departamento dep = departamentos.get( nDep);
		BeneficiosProductos prod = listaProductos.get( nP );

		switch ( columnIndex ) {
			case 0: return prod.getProducto();
			case 1: return prod.getPrecioCompra();
			case 2: return prod.getPrecioVenta();
			case 3: return prod.getCantidad();
			case 4: return prod.getBeneficio();
			case 5: return prod.getProveedor();
			case 6: return prod.getTelefono();
			case 7: return prod.getWeb();
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
		listaProductos = Controlador.getListaStockBeneficios();
		if( listaProductos == null) return; 
		System.out.println("Numero de lineas: " + listaProductos.size());
	}
}
