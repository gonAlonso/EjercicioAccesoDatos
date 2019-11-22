package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Pedido;

public class ModeloComboPedidos extends JComboBox<Pedido>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pedido> listaPedidos = null;
	
	public ModeloComboPedidos(){
		recargarListaPedidos();
	}
	
	public void actualizarComboPedidos() {
		this.removeAllItems();
		for( Pedido ped : listaPedidos) {
			this.addItem( ped );
		}
	}
	
	public void recargarListaPedidos() {
		listaPedidos = Controlador.cargarListaPedidos();
		if (listaPedidos == null) return;
		actualizarComboPedidos();
	}
	
	public void selectPedido( int num) {
		for( Pedido p : listaPedidos ) {
			if( p.getNumPedido() == num)
				setSelectedItem( p );
		}
	}
	
	public void addEmptyElm() {
		Pedido ped = new Pedido();
		ped.setNifCliente("***");
		ped.setNumPedido(0);
		ped.setFecha( null);
		this.addItem( ped );
		setSelectedItem( ped );
	}
}