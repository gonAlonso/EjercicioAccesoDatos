package vista;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import controlador.Controlador;
import modeloVo.LineaFacturaMes;
import modeloVo.LineaPedido;
import modeloVo.Pedido;
import modeloVo.ProductosBajoMinimo;

public class ModeloTablaLineasFacturas extends AbstractTableModel {
	private ArrayList<LineaFacturaMes> listaFacturas = null;
	private ArrayList<String> nombresColumnas = null;
	//private double resultados[];
	
	
	// Añadir nf.format
	public ModeloTablaLineasFacturas() {
		super();
		nombresColumnas = new ArrayList<String>();

		nombresColumnas.add( "Nº Pedido" );
		nombresColumnas.add( "Fecha" );
		nombresColumnas.add( "Base Imponible" );
		nombresColumnas.add( "IVA" );
		nombresColumnas.add( "Total" );
		listaFacturas = new ArrayList<LineaFacturaMes>();
	}
	
	
	@Override
	public Object getValueAt(int nP, int columnIndex) {
		LineaFacturaMes facts = listaFacturas.get( nP );
		switch ( columnIndex ) {
			case 0: return facts.getNumero();
			case 1: return facts.getFecha();
			case 2: return facts.getBaseImponible();
			case 3: return facts.getIva();
			case 4: return facts.getTotal();
			default: throw new IllegalArgumentException("Unexpected value: " +  columnIndex );
		}
	}

	@Override
	public int getRowCount() {
		return (listaFacturas==null)? 0 : listaFacturas.size();
	}

	@Override
	public int getColumnCount() {
		return nombresColumnas.size();
	}
	
	@Override
	public String getColumnName(int column) {
		return this.nombresColumnas.get(column);
	}
	
	public void cargarLineasMes(int mes) {
		listaFacturas = Controlador.getListaFacturasMes( mes );
		fireTableDataChanged();
	}
	
	public void cargarLineasCliente(String nif) {
		listaFacturas = Controlador.getListaFacturasCliente( nif );
		fireTableDataChanged();
	}

	public void clear() {
		listaFacturas.clear();
	}
}
