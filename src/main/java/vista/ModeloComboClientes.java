package vista;

import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Pedido;

public class ModeloComboClientes extends JComboBox<Cliente>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> listaClientes = null;
	
	public ModeloComboClientes(){
		cargarListaClientes();
	}
	
	public void cargarListaClientes() {
		listaClientes = Controlador.cargarListaClientes();
		if (listaClientes== null) return;
		for( Cliente cli : listaClientes) {
			this.addItem( cli );
		}
	}
	
	public boolean selectCliente(String nif ) {
		for( int i=0; i<this.getItemCount(); i++) {
			if ( ((Cliente)this.getItemAt(i)).getNif().equalsIgnoreCase(nif) ) {
				setSelectedIndex( i );
				return true;
			}
		}
		return false;
	}
}